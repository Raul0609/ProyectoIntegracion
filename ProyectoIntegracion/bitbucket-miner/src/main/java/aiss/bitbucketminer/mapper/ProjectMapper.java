package aiss.bitbucketminer.mapper;

import aiss.bitbucketminer.model.ProjectDTO;
import aiss.bitbucketminer.model.CommitDTO;
import aiss.bitbucketminer.model.IssueDTO;
import aiss.gitminer.model.Project;
import aiss.gitminer.model.Commit;
import aiss.gitminer.model.Issue;
import aiss.bitbucketminer.mapper.CommitMapper;
import aiss.bitbucketminer.mapper.IssueMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    /**
     * Transforma un `ProjectDTO` de Bitbucket en un `Project` compatible con GitMiner.
     */
    public static Project transformProject(ProjectDTO dto, List<CommitDTO> commitDTOs, List<IssueDTO> issueDTOs) {
        Project project = new Project();
        project.setId(dto.getUuid()); // Usamos el UUID del proyecto como ID
        project.setName(dto.getName());
        project.setWebUrl(dto.getLinks().getSelf().getHref()); // Tomamos el enlace al proyecto

        // Transformamos los commits
        List<Commit> commits = commitDTOs.stream()
                .map(CommitMapper::transformCommit)
                .collect(Collectors.toList());
        project.setCommits(commits);

        // Transformamos los issues
        List<Issue> issues = issueDTOs.stream()
                .map(IssueMapper::transformIssue)
                .collect(Collectors.toList());
        project.setIssues(issues);

        return project;
    }
}