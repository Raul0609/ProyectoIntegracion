package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.service.ProjectService;
import aiss.bitbucketminer.model.ProjectDTO;
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
     * Obtiene los proyectos de un workspace desde Bitbucket, sin transformación.
     */
    @GetMapping("/{workspace}")
    public ResponseEntity<List<ProjectDTO>> getProjects(@PathVariable String workspace) {
        List<ProjectDTO> projects = projectService.fetchProjects(workspace);
        return ResponseEntity.ok(projects);
    }

    /**
     * Extrae, transforma y envía los proyectos con sus commits e issues a GitMiner.
     * Se pueden especificar parámetros opcionales para limitar los datos.
     */
    @PostMapping("/{workspace}/process")
    public ResponseEntity<String> processAndSendProjects(@PathVariable String workspace,
                                                         @RequestParam(defaultValue = "5") int nCommits,
                                                         @RequestParam(defaultValue = "5") int nIssues,
                                                         @RequestParam(defaultValue = "2") int maxPages) {
        List<Project> processedProjects = projectService.processProjects(workspace);
        return ResponseEntity.ok("Proyectos procesados y enviados correctamente a GitMiner. Total: " + processedProjects.size());
    }
}