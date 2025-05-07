package aiss.githubminer.mapper;

import aiss.githubminer.model.UserDTO;
import aiss.gitminer.model.User;

public class UserMapper {

    /**
     * Transforma un `UserDTO` en un `User`, adaptando los datos al modelo de GitMiner.
     */
    public static User transformUser(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId() != null ? dto.getId().toString() : "Unknown");
        user.setUsername(dto.getLogin() != null ? dto.getLogin() : "Unknown User");
        user.setName(dto.getName() != null ? dto.getName() : "Unknown Name");
        user.setAvatarUrl(dto.getAvatarUrl() != null ? dto.getAvatarUrl() : "Unknown Avatar");
        user.setWebUrl(dto.getUrl() != null ? dto.getUrl() : "Unknown URL");

        return user;
    }

}