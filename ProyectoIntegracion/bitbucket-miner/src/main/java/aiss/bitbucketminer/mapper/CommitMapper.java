package aiss.bitbucketminer.mapper;

import aiss.bitbucketminer.model.CommitDTO;
import aiss.gitminer.model.Commit;

public class CommitMapper {

    /**
     * Transforma un `CommitDTO` de Bitbucket en un `Commit` compatible con GitMiner.
     */
    public static Commit transformCommit(CommitDTO dto) {
        Commit commit = new Commit();
        commit.setId(dto.getHash());
        commit.setTitle(dto.getMessage().split("\n")[0]); // Usa la primera línea del mensaje como título
        commit.setMessage(dto.getMessage());
        commit.setAuthorName(dto.getAuthor().getDisplayName());
        commit.setAuthorEmail(""); // Bitbucket no proporciona email en la respuesta del commit
        commit.setAuthoredDate(dto.getDate());
        commit.setWebUrl(""); // Bitbucket no proporciona enlace

        return commit;
    }
}