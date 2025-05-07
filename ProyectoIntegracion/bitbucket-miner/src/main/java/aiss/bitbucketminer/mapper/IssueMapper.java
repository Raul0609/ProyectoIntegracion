package aiss.bitbucketminer.mapper;

import aiss.bitbucketminer.model.IssueDTO;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.User;

import java.util.List;

public class IssueMapper {

    /**
     * Transforma un `IssueDTO` de Bitbucket en un `Issue` compatible con GitMiner.
     */
    public static Issue transformIssue(IssueDTO dto) {
        Issue issue = new Issue();
        issue.setId(String.valueOf(dto.getId()));
        issue.setTitle(dto.getTitle());
        issue.setDescription(dto.getContent().getRaw()); // Toma la descripción sin formato
        issue.setState(dto.getState());
        issue.setCreatedAt(dto.getCreatedOn());
        issue.setUpdatedAt(dto.getUpdatedOn());
        issue.setClosedAt(dto.getEditedOn());
        issue.setLabels(dto.getPriority() != null ? List.of(dto.getPriority()) : List.of()); // Usa la prioridad como etiquetas
        issue.setVotes(dto.getVotes());

        // Mapeo del usuario creador
        User author = new User();
        issue.setAuthor(author);

        // Mapeo del usuario asignado
        if (dto.getAssignee() != null) {
            User asignee = new User();
            issue.setAuthor(asignee);
        } else {
            issue.setAssignee(null);
        }

        return issue;
    }
}