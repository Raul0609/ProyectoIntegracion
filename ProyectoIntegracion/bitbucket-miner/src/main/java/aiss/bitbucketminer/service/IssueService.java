package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.IssueDTO;
import aiss.bitbucketminer.model.CommentDTO;
import aiss.bitbucketminer.mapper.IssueMapper;
import aiss.bitbucketminer.mapper.CommentMapper;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BITBUCKET_API_BASE_URL = "https://api.bitbucket.org/2.0/repositories/";
    private static final String GITMINER_API_URL = "http://gitminer-service/api/issues"; // URL del servicio GitMiner

    /**
     * Obtiene issues desde Bitbucket para un repositorio determinado.
     */
    public List<IssueDTO> fetchIssues(String workspace, String repoSlug, int nIssues) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/issues?pagelen=" + nIssues;
        IssueDTO[] response = restTemplate.getForObject(url, IssueDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene los comentarios asociados a un issue desde Bitbucket.
     */
    public List<CommentDTO> fetchComments(String workspace, String repoSlug, String issueId) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/issues/" + issueId + "/comments";
        CommentDTO[] response = restTemplate.getForObject(url, CommentDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea una lista de `IssueDTO` a `Issue`, adaptando los datos al modelo GitMiner.
     */
    public List<Issue> mapIssues(List<IssueDTO> issueDTOs) {
        return issueDTOs.stream()
                .map(IssueMapper::transformIssue)
                .collect(Collectors.toList());
    }

    /**
     * Asocia los comentarios a cada issue después de mapearlos.
     */
    public void associateCommentsToIssues(String workspace, String repoSlug, List<Issue> issues) {
        for (Issue issue : issues) {
            List<CommentDTO> commentDTOs = fetchComments(workspace, repoSlug, issue.getId());
            List<Comment> comments = commentDTOs.stream()
                    .map(CommentMapper::transformComment)
                    .collect(Collectors.toList());
            issue.setComments(comments);
        }
    }

    /**
     * Envía los issues transformados a GitMiner.
     */
    public void sendIssuesToGitMiner(List<Issue> issues) {
        if (issues.isEmpty()) {
            throw new IllegalArgumentException("No hay issues para enviar a GitMiner.");
        }

        restTemplate.postForEntity(GITMINER_API_URL, issues, String.class);
        System.out.println("Issues enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de issues.
     */
    public List<Issue> processIssues(String workspace, String repoSlug, int nIssues) {
        List<IssueDTO> issueDTOs = fetchIssues(workspace, repoSlug, nIssues);
        List<Issue> processedIssues = mapIssues(issueDTOs);
        associateCommentsToIssues(workspace, repoSlug, processedIssues); // Asocia comentarios a los issues
        sendIssuesToGitMiner(processedIssues);
        return processedIssues;
    }
}