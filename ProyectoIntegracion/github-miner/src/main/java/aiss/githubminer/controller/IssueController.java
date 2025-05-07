package aiss.githubminer.controller;

import aiss.githubminer.service.IssueService;
import aiss.githubminer.model.IssueDTO;
import aiss.gitminer.model.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * 🔹 Obtiene los issues de un repositorio en GitHub, sin transformación.
     */
    @GetMapping("/github/{owner}/{repo}")
    public ResponseEntity<List<IssueDTO>> getGitHubIssues(@PathVariable String owner,
                                                          @PathVariable String repo) {
        List<IssueDTO> issues = issueService.fetchIssues(owner, repo);
        return ResponseEntity.ok(issues);
    }

    /**
     * 🔹 Extrae, transforma y envía los issues de un repositorio a GitMiner.
     */
    @PostMapping("/{owner}/{repo}/process")
    public ResponseEntity<String> processAndSendIssues(@PathVariable String owner,
                                                       @PathVariable String repo) {
        List<Issue> processedIssues = issueService.processIssues(owner, repo);
        return ResponseEntity.ok("Issues procesados y enviados correctamente a GitMiner. Total: " + processedIssues.size());
    }
}