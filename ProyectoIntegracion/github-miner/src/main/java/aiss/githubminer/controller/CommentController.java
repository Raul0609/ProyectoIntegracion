package aiss.githubminer.controller;

import aiss.githubminer.service.CommentService;
import aiss.githubminer.model.CommentDTO;
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
     * Obtiene los comentarios de un issue específico desde GitHub, sin transformación.
     */
    @GetMapping("/{owner}/{repo}/{issueId}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable String owner,
                                                        @PathVariable String repo,
                                                        @PathVariable String issueId) {
        List<CommentDTO> comments = commentService.fetchComments(owner, repo, issueId);
        return ResponseEntity.ok(comments);
    }

    /**
     * Extrae, transforma y envía los comentarios de un issue a GitMiner.
     */
    @PostMapping("/{owner}/{repo}/{issueId}/process")
    public ResponseEntity<String> processAndSendComments(@PathVariable String owner,
                                                         @PathVariable String repo,
                                                         @PathVariable String issueId) {
        List<Comment> processedComments = commentService.processComments(owner, repo, issueId);
        return ResponseEntity.ok("Comentarios procesados y enviados correctamente a GitMiner. Total: " + processedComments.size());
    }
}