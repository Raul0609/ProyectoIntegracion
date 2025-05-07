package aiss.githubminer.controller;

import aiss.githubminer.service.ProjectService;
import aiss.githubminer.model.ProjectDTO;
import aiss.gitminer.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 🔹 Obtiene la información de un proyecto en GitHub, sin transformación.
     */
    @GetMapping("/github/{owner}/{repo}")
    public ResponseEntity<ProjectDTO> getGitHubProject(@PathVariable String owner,
                                                       @PathVariable String repo) {
        ProjectDTO project = projectService.fetchProject(owner, repo);
        return ResponseEntity.ok(project);
    }

    /**
     * 🔹 Extrae, transforma y envía la información de un proyecto a GitMiner.
     */
    @PostMapping("/{owner}/{repo}/process")
    public ResponseEntity<String> processAndSendProject(@PathVariable String owner,
                                                        @PathVariable String repo) {
        Project processedProject = projectService.processProject(owner, repo);
        return ResponseEntity.ok("Proyecto procesado y enviado correctamente a GitMiner: " + processedProject.getName());
    }
}