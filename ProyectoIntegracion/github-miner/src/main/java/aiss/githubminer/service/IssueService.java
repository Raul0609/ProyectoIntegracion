package aiss.githubminer.service;

import aiss.githubminer.model.CommentDTO;
import aiss.githubminer.model.IssueDTO;
import aiss.gitminer.model.Issue;
import aiss.githubminer.mapper.IssueMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos/";

    /**
     * Obtiene issues desde GitHub para un repositorio determinado.
     */
    public List<IssueDTO> fetchIssues(String owner, String repo) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo + "/issues";
        IssueDTO[] response = restTemplate.getForObject(url, IssueDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene comentarios reales de un issue desde GitHub.
     */
    public List<CommentDTO> fetchIssueComments(String commentsUrl) {
        CommentDTO[] response = restTemplate.getForObject(commentsUrl, CommentDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea una lista de `IssueDTO` a `Issue`, incluyendo comentarios reales.
     */
    public List<Issue> mapIssues(List<IssueDTO> issueDTOs) {
        return issueDTOs.stream().map(issueDTO -> {
            List<CommentDTO> comments = fetchIssueComments(issueDTO.getCommentsUrl());
            return IssueMapper.transformIssue(issueDTO, comments);
        }).collect(Collectors.toList());
    }

    /**
     * Envía los issues transformados a GitMiner.
     */
    public void sendIssuesToGitMiner(List<Issue> issues) {
        if (issues.isEmpty()) {
            throw new IllegalArgumentException("No hay issues para enviar a GitMiner.");
        }

        String gitMinerUrl = "http://gitminer-service/api/issues";
        restTemplate.postForEntity(gitMinerUrl, issues, String.class);

        System.out.println("Issues enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de issues.
     */
    public List<Issue> processIssues(String owner, String repo) {
        List<IssueDTO> issueDTOs = fetchIssues(owner, repo);
        List<Issue> processedIssues = mapIssues(issueDTOs);
        sendIssuesToGitMiner(processedIssues);
        return processedIssues;
    }
}