package aiss.githubminer.service;

import aiss.githubminer.mapper.IssueMapper;
import aiss.githubminer.model.CommentDTO;
import aiss.githubminer.model.CommitDTO;
import aiss.githubminer.model.IssueDTO;
import aiss.githubminer.model.ProjectDTO;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;
import aiss.githubminer.mapper.ProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos/";

    /**
     * Obtiene los datos de un proyecto desde GitHub.
     */
    public ProjectDTO fetchProject(String owner, String repo) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo;
        return restTemplate.getForObject(url, ProjectDTO.class);
    }

    /**
     * Obtiene los issues de un proyecto desde GitHub.
     */
    public List<IssueDTO> fetchProjectIssues(String owner, String repo) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo + "/issues";
        IssueDTO[] response = restTemplate.getForObject(url, IssueDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene los commits de un proyecto desde GitHub.
     */
    public List<CommitDTO> fetchProjectCommits(String owner, String repo) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo + "/commits";
        CommitDTO[] response = restTemplate.getForObject(url, CommitDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Obtiene los comentarios de un issue desde GitHub.
     */
    public List<CommentDTO> fetchIssueComments(String commentsUrl) {
        CommentDTO[] response = restTemplate.getForObject(commentsUrl, CommentDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea un IssueDTO a Issue, incluyendo comentarios reales.
     */
    public List<Issue> mapIssues(List<IssueDTO> issueDTOs) {
        return issueDTOs.stream().map(issueDTO -> {
            List<CommentDTO> comments = fetchIssueComments(issueDTO.getCommentsUrl());
            return IssueMapper.transformIssue(issueDTO, comments);
        }).collect(Collectors.toList());
    }

    /**
     * Envía el proyecto transformado a GitMiner.
     */
    public void sendProjectToGitMiner(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("No hay proyecto para enviar a GitMiner.");
        }

        String gitMinerUrl = "http://gitminer-service/api/projects";
        restTemplate.postForEntity(gitMinerUrl, project, String.class);
        System.out.println("Proyecto enviado correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de un proyecto a GitMiner.
     */
    public Project processProject(String owner, String repo) {
        ProjectDTO projectDTO = fetchProject(owner, repo);
        List<CommitDTO> commitDTOs = fetchProjectCommits(owner, repo);
        List<IssueDTO> issueDTOs = fetchProjectIssues(owner, repo);
        List<Issue> issues = mapIssues(issueDTOs);

        Project project = ProjectMapper.transformProject(projectDTO, commitDTOs, issues);
        sendProjectToGitMiner(project);
        return project;
    }
}