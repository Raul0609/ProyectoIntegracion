package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.service.IssueService;
import aiss.bitbucketminer.model.IssueDTO;
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
     * Obtiene los issues de un repositorio específico desde Bitbucket, sin transformación.
     * Se puede especificar el número de issues a obtener.
     */
    @GetMapping("/{workspace}/{repo_slug}")
    public ResponseEntity<List<IssueDTO>> getIssues(@PathVariable String workspace,
                                                    @PathVariable String repo_slug,
                                                    @RequestParam(defaultValue = "5") int nIssues) {
        List<IssueDTO> issues = issueService.fetchIssues(workspace, repo_slug, nIssues);
        return ResponseEntity.ok(issues);
    }

    /**
     * Extrae, transforma y envía los issues de un repositorio a GitMiner.
     * Se puede especificar el número de issues a procesar.
     */
    @PostMapping("/{workspace}/{repo_slug}/process")
    public ResponseEntity<String> processAndSendIssues(@PathVariable String workspace,
                                                       @PathVariable String repo_slug,
                                                       @RequestParam(defaultValue = "5") int nIssues) {
        List<Issue> processedIssues = issueService.processIssues(workspace, repo_slug, nIssues);
        return ResponseEntity.ok("Issues procesados y enviados correctamente a GitMiner. Total: " + processedIssues.size());
    }
}