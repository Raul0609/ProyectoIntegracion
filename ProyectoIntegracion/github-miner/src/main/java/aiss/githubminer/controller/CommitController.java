package aiss.githubminer.controller;

import aiss.githubminer.service.CommitService;
import aiss.githubminer.model.CommitDTO;
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
     * Obtiene los commits de un repositorio en GitHub, sin transformación.
     */
    @GetMapping("/github/{owner}/{repo}")
    public ResponseEntity<List<CommitDTO>> getGitHubCommits(@PathVariable String owner,
                                                            @PathVariable String repo) {
        List<CommitDTO> commits = commitService.fetchCommits(owner, repo);
        return ResponseEntity.ok(commits);
    }

    /**
     * Extrae, transforma y envía los commits de un repositorio a GitMiner.
     */
    @PostMapping("/{owner}/{repo}/process")
    public ResponseEntity<String> processAndSendCommits(@PathVariable String owner,
                                                        @PathVariable String repo) {
        List<Commit> processedCommits = commitService.processCommits(owner, repo);
        return ResponseEntity.ok("Commits procesados y enviados correctamente a GitMiner. Total: " + processedCommits.size());
    }
}