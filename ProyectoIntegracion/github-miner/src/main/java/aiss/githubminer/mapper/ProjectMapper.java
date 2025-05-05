package aiss.githubminer.mapper;

import aiss.githubminer.model.CommitDTO;
import aiss.githubminer.model.ProjectDTO;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project transformProject(ProjectDTO dto, List<CommitDTO> commitDTOs, List<Issue> issues) {
        if (dto == null) {
            return null;
        }

        Project project = new Project();
        project.setId(dto.getId() != null ? dto.getId().toString() : "Unknown");
        project.setName(dto.getName() != null ? dto.getName() : "No Name");
        project.setWebUrl(dto.getHtmlUrl() != null ? dto.getHtmlUrl() : "No URL");

        project.setCommits(commitDTOs.stream().map(CommitMapper::transformCommit).collect(Collectors.toList()));
        project.setIssues(issues);

        return project;
    }

}