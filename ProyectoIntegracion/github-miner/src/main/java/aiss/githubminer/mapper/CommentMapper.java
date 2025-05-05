package aiss.githubminer.mapper;

import aiss.githubminer.model.CommentDTO;
import aiss.gitminer.model.Comment;
import aiss.gitminer.model.User;

public class CommentMapper {

    /**
     * Transforma un `CommentDTO` en un `Comment`, adaptando los datos al modelo de GitMiner.
     */
    public static Comment transformComment(CommentDTO dto) {
        if (dto == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setId(dto.getId() != null ? dto.getId().toString() : "Unknown");
        comment.setBody(dto.getBody() != null ? dto.getBody() : "");
        comment.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : "Unknown Date");
        comment.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : "Unknown Date");

        // Mapeo del usuario
        if (dto.getUser() != null) {
            User user = UserMapper.transformUser(dto.getUser());
            comment.setAuthor(user);
        } else {
            comment.setAuthor(null);
        }

        return comment;
    }
}