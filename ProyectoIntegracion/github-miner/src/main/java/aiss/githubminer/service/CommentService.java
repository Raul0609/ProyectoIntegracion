package aiss.githubminer.service;

import aiss.githubminer.model.CommentDTO;
import aiss.githubminer.mapper.CommentMapper;
import aiss.gitminer.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos/";

    /**
     * Obtiene comentarios desde GitHub para un issue determinado.
     */
    public List<CommentDTO> fetchComments(String owner, String repo, int issueNumber) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo + "/issues/" + issueNumber + "/comments";
        CommentDTO[] response = restTemplate.getForObject(url, CommentDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea una lista de `CommentDTO` a `Comment`, adaptando los datos al modelo GitMiner.
     */
    public List<Comment> mapComments(List<CommentDTO> commentDTOs) {
        return commentDTOs.stream()
                .map(CommentMapper::transformComment)
                .collect(Collectors.toList());
    }

    /**
     * Envía los comentarios transformados a GitMiner.
     */
    public void sendCommentsToGitMiner(List<Comment> comments) {
        if (comments.isEmpty()) {
            throw new IllegalArgumentException("No hay comentarios para enviar a GitMiner.");
        }

        String gitMinerUrl = "http://gitminer-service/api/comments";
        restTemplate.postForEntity(gitMinerUrl, comments, String.class);

        System.out.println("Comentarios enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de comentarios.
     */
    public List<Comment> processComments(String owner, String repo, int issueId) {
        List<CommentDTO> commentDTOs = fetchComments(owner, repo, issueId);
        List<Comment> processedComments = mapComments(commentDTOs);

        sendCommentsToGitMiner(processedComments);
        return processedComments;
    }
}