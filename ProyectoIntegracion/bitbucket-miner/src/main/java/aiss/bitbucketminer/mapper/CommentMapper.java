package aiss.bitbucketminer.mapper;

import aiss.bitbucketminer.model.CommentDTO;
import aiss.gitminer.model.Comment;

public class CommentMapper {

    /**
     * Transforma un `CommentDTO` de Bitbucket en un `Comment` compatible con GitMiner.
     */
    public static Comment transformComment(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(String.valueOf(dto.getId())); // Convertimos el ID a String
        comment.setBody(dto.getContent().getRaw()); // Tomamos el contenido sin formato
        comment.setCreatedAt(dto.getCreatedOn());
        comment.setUpdatedAt(dto.getUpdatedOn());

        // Mapeo del usuario
        //TODO cuando implementemos el mapeo de usuario usarlo aqui

        return comment;
    }
}