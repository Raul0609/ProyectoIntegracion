package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.ProjectDTO;
import aiss.bitbucketminer.model.CommitDTO;
import aiss.bitbucketminer.model.IssueDTO;
import aiss.bitbucketminer.mapper.ProjectMapper;
import aiss.gitminer.model.Project;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProjectService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BITBUCKET_API_BASE_URL = "https://api.bitbucket.org/2.0/workspaces/";
    private static final String GITMINER_API_URL = "http://gitminer-service/api/projects"; // URL del servicio GitMiner

    /**
     * Obtiene los proyectos desde Bitbucket.
     */
    public List<ProjectDTO> fetchProjects(String workspace) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/projects";
        ProjectDTO[] response = restTemplate.getForObject(url, ProjectDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene los commits asociados a un proyecto desde Bitbucket.
     */
    public List<CommitDTO> fetchCommits(String workspace, String repoSlug) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/commits";
        CommitDTO[] response = restTemplate.getForObject(url, CommitDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene los issues asociados a un proyecto desde Bitbucket.
     */
    public List<IssueDTO> fetchIssues(String workspace, String repoSlug) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/issues";
        IssueDTO[] response = restTemplate.getForObject(url, IssueDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Envía los proyectos transformados a GitMiner.
     */
    public void sendProjectsToGitMiner(List<Project> projects) {
        if (projects.isEmpty()) {
            throw new IllegalArgumentException("No hay proyectos para enviar a GitMiner.");
        }

        restTemplate.postForEntity(GITMINER_API_URL, projects, String.class);
        System.out.println("Proyectos enviados correctamente a GitMiner.");
    }

    /**
     * Mapea los proyectos y sus datos asociados antes de enviarlos a GitMiner.
     */
    public List<Project> processProjects(String workspace) {
        List<ProjectDTO> projectDTOs = fetchProjects(workspace);
        List<Project> projects = projectDTOs.stream().map(dto -> {
            List<CommitDTO> commitDTOs = fetchCommits(workspace, dto.getKey()); // Repositorio asociado al proyecto
            List<IssueDTO> issueDTOs = fetchIssues(workspace, dto.getKey());
            return ProjectMapper.transformProject(dto, commitDTOs, issueDTOs);
        }).toList();

        sendProjectsToGitMiner(projects);
        return projects;
    }
}