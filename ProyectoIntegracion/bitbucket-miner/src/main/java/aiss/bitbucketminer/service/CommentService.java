package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.CommentDTO;
import aiss.bitbucketminer.mapper.CommentMapper;
import aiss.gitminer.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BITBUCKET_API_BASE_URL = "https://api.bitbucket.org/2.0/repositories/";
    private static final String GITMINER_API_URL = "http://gitminer-service/api/comments"; // URL del servicio GitMiner

    /**
     * Obtiene comentarios desde Bitbucket para un issue determinado.
     */
    public List<CommentDTO> fetchComments(String workspace, String repoSlug, String issueId) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/issues/" + issueId + "/comments";
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

        restTemplate.postForEntity(GITMINER_API_URL, comments, String.class);
        System.out.println("Comentarios enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de comentarios.
     */
    public List<Comment> processComments(String workspace, String repoSlug, String issueId) {
        List<CommentDTO> commentDTOs = fetchComments(workspace, repoSlug, issueId);
        List<Comment> processedComments = mapComments(commentDTOs);
        sendCommentsToGitMiner(processedComments);
        return processedComments;
    }
}