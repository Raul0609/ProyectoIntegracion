package aiss.githubminer.mapper;

import aiss.githubminer.model.CommitDTO;
import aiss.githubminer.model.commitDependencies.CommitDetailsDTO;
import aiss.githubminer.model.commitDependencies.CommitAuthorDTO;
import aiss.gitminer.model.Commit;

public class CommitMapper {

    private static final int TITLE_LENGTH = 50; // Tamaño máximo del título

    /**
     * Transforma un `CommitDTO` en un `Commit`, adaptando los datos al modelo de GitMiner.
     */
    public static Commit transformCommit(CommitDTO dto) {
        if (dto == null) {
            return null;
        }

        Commit commit = new Commit();
        commit.setId(dto.getSha() != null ? dto.getSha() : "Unknown");
        commit.setWebUrl(dto.getHtmlUrl() != null ? dto.getHtmlUrl() : "Unknown URL");

        // Mapeo de detalles del commit
        CommitDetailsDTO details = dto.getCommit();
        if (details != null) {
            commit.setMessage(details.getMessage() != null ? details.getMessage() : "No message");

            // Generar el título usando los primeros caracteres del mensaje
            commit.setTitle(generateTitleFromMessage(details.getMessage()));

            // Mapeo del autor del commit
            CommitAuthorDTO author = details.getAuthor();
            if (author != null) {
                commit.setAuthorName(author.getName() != null ? author.getName() : "Unknown Author");
                commit.setAuthorEmail(author.getEmail() != null ? author.getEmail() : "Unknown Email");
                commit.setAuthoredDate(author.getDate() != null ? author.getDate() : "Unknown Date");
            }
        }

        return commit;
    }

    /**
     * Genera un título basado en los primeros caracteres del mensaje del commit.
     */
    private static String generateTitleFromMessage(String message) {
        if (message == null || message.isEmpty()) {
            return "No title";
        }
        return message.length() <= TITLE_LENGTH ? message : message.substring(0, TITLE_LENGTH) + "...";
    }
}