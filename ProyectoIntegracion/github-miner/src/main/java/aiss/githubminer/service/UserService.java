package aiss.githubminer.service;

import aiss.githubminer.model.UserDTO;
import aiss.gitminer.model.User;
import aiss.githubminer.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/users/";

    /**
     * Obtiene los datos de un usuario desde GitHub.
     */
    public UserDTO fetchUser(String username) {
        String url = GITHUB_API_BASE_URL + username;
        return restTemplate.getForObject(url, UserDTO.class);
    }

    /**
     * Transforma un `UserDTO` en `User`, adaptando los datos al modelo de GitMiner.
     */
    public User mapUser(UserDTO userDTO) {
        return UserMapper.transformUser(userDTO);
    }

    /**
     * Envía el usuario transformado a GitMiner.
     */
    public void sendUserToGitMiner(User user) {
        if (user == null) {
            throw new IllegalArgumentException("No hay usuario para enviar a GitMiner.");
        }

        String gitMinerUrl = "http://gitminer-service/api/users";
        restTemplate.postForEntity(gitMinerUrl, user, String.class);

        System.out.println("Usuario enviado correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de un usuario a GitMiner.
     */
    public User processUser(String username) {
        UserDTO userDTO = fetchUser(username);
        User user = mapUser(userDTO);
        sendUserToGitMiner(user);
        return user;
    }
}