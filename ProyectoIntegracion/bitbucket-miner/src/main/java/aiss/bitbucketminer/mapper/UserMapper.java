package aiss.bitbucketminer.mapper;

import aiss.bitbucketminer.model.UserDTO;
import aiss.gitminer.model.User;

public class UserMapper {

    /**
     * Transforma un `UserDTO` de Bitbucket en un `User` compatible con GitMiner.
     */
    public static User transformUser(UserDTO dto) {
        User user = new User();
        user.setId(dto.getUuid()); // Usamos el UUID como identificador
        user.setUsername(dto.getDisplayName());
        user.setName(""); // Bitbucket no proporciona un campo específico para el nombre completo
        user.setAvatarUrl(dto.getLinks().getAvatar().getHref()); // URL del avatar
        user.setWebUrl(""); // Bitbucket no proporciona un campo específico para la url

        return user;
    }
}