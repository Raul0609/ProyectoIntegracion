package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.UserDTO;
import aiss.bitbucketminer.mapper.UserMapper;
import aiss.gitminer.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BITBUCKET_API_BASE_URL = "https://api.bitbucket.org/2.0/workspaces/";
    private static final String GITMINER_API_URL = "http://gitminer-service/api/users"; // URL del servicio GitMiner

    /**
     * Obtiene usuarios desde Bitbucket para un workspace determinado.
     */
    public List<UserDTO> fetchUsers(String workspace) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/members";
        UserDTO[] response = restTemplate.getForObject(url, UserDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea una lista de `UserDTO` a `User`, adaptando los datos al modelo GitMiner.
     */
    public List<User> mapUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream()
                .map(UserMapper::transformUser)
                .collect(Collectors.toList());
    }

    /**
     * Envía los usuarios transformados a GitMiner.
     */
    public void sendUsersToGitMiner(List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("No hay usuarios para enviar a GitMiner.");
        }

        restTemplate.postForEntity(GITMINER_API_URL, users, String.class);
        System.out.println("Usuarios enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de usuarios.
     */
    public List<User> processUsers(String workspace) {
        List<UserDTO> userDTOs = fetchUsers(workspace);
        List<User> processedUsers = mapUsers(userDTOs);
        sendUsersToGitMiner(processedUsers);
        return processedUsers;
    }
}