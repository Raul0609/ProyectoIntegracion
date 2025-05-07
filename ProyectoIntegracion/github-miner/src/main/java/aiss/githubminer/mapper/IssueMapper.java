package aiss.githubminer.mapper;

import aiss.githubminer.model.CommentDTO;
import aiss.githubminer.model.IssueDTO;
import aiss.githubminer.model.issueDependencies.LabelDTO;
import aiss.githubminer.model.UserDTO;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.Issue;
import aiss.gitminer.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class IssueMapper {

    /**
     * Transforma un `IssueDTO` en un `Issue`, adaptando los datos al modelo de GitMiner.
     */
    public static Issue transformIssue(IssueDTO dto, List<CommentDTO> commentDTOs) {
        if (dto == null) {
            return null;
        }

        Issue issue = new Issue();
        issue.setId(dto.getId() != null ? dto.getId().toString() : "Unknown");
        issue.setTitle(dto.getTitle() != null ? dto.getTitle() : "No Title");
        issue.setDescription(dto.getBody() != null ? dto.getBody() : "No Description");
        issue.setState(dto.getState() != null ? dto.getState() : "Unknown State");
        issue.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : "Unknown Date");
        issue.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : "Unknown Date");
        issue.setClosedAt(dto.getClosedAt() != null ? dto.getClosedAt() : null);
        issue.setVotes(dto.getComments() != null ? dto.getComments() : 0);

        // Mapeo de etiquetas
        List<String> labels = dto.getLabels() != null
                ? dto.getLabels().stream().map(LabelDTO::getName).collect(Collectors.toList())
                : List.of();
        issue.setLabels(labels);

        // Mapeo del autor
        if (dto.getUser() != null) {
            User user = UserMapper.transformUser(dto.getUser());
            issue.setAuthor(user);
        } else {
            issue.setAuthor(null);
        }

        // Mapeo del asignado
        if (dto.getUser() != null) {
            User user = UserMapper.transformUser(dto.getUser());
            issue.setAssignee(user);
        } else {
            issue.setAssignee(null);
        }

        // Mapeo de comentarios reales obtenidos desde GitHub
        List<Comment> comments = commentDTOs.stream().map(CommentMapper::transformComment).collect(Collectors.toList());
        issue.setComments(comments);

        return issue;
    }

}