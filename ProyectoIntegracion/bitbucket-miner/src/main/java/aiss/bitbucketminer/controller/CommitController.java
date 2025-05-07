package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.service.CommitService;
import aiss.bitbucketminer.model.CommitDTO;
import aiss.gitminer.model.Commit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commits")
public class CommitController {

    private final CommitService commitService;

    public CommitController(CommitService commitService) {
        this.commitService = commitService;
    }

    /**
     * Obtiene los commits de un repositorio específico desde Bitbucket, sin transformación.
     * Se puede especificar el número de commits a obtener.
     */
    @GetMapping("/{workspace}/{repo_slug}")
    public ResponseEntity<List<CommitDTO>> getCommits(@PathVariable String workspace,
                                                      @PathVariable String repo_slug,
                                                      @RequestParam(defaultValue = "5") int nCommits) {
        List<CommitDTO> commits = commitService.fetchCommits(workspace, repo_slug, nCommits);
        return ResponseEntity.ok(commits);
    }

    /**
     * Extrae, transforma y envía los commits de un repositorio a GitMiner.
     * Se puede especificar el número de commits a procesar.
     */
    @PostMapping("/{workspace}/{repo_slug}/process")
    public ResponseEntity<String> processAndSendCommits(@PathVariable String workspace,
                                                        @PathVariable String repo_slug,
                                                        @RequestParam(defaultValue = "5") int nCommits) {
        List<Commit> processedCommits = commitService.processCommits(workspace, repo_slug, nCommits);
        return ResponseEntity.ok("Commits procesados y enviados correctamente a GitMiner. Total: " + processedCommits.size());
    }
}