package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.service.CommentService;
import aiss.bitbucketminer.model.CommentDTO;
import aiss.gitminer.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Obtiene los comentarios de un issue específico desde Bitbucket, sin transformación.
     */
    @GetMapping("/{workspace}/{repo_slug}/{issueId}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable String workspace,
                                                        @PathVariable String repo_slug,
                                                        @PathVariable String issueId) {
        List<CommentDTO> comments = commentService.fetchComments(workspace, repo_slug, issueId);
        return ResponseEntity.ok(comments);
    }

    /**
     * Extrae, transforma y envía los comentarios de un issue a GitMiner.
     */
    @PostMapping("/{workspace}/{repo_slug}/{issueId}/process")
    public ResponseEntity<String> processAndSendComments(@PathVariable String workspace,
                                                         @PathVariable String repo_slug,
                                                         @PathVariable String issueId) {
        List<Comment> processedComments = commentService.processComments(workspace, repo_slug, issueId);
        return ResponseEntity.ok("Comentarios procesados y enviados correctamente a GitMiner. Total: " + processedComments.size());
    }
}