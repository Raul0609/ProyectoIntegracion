package aiss.bitbucketminer.controller;

import aiss.bitbucketminer.service.UserService;
import aiss.bitbucketminer.model.UserDTO;
import aiss.gitminer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Obtiene los usuarios desde Bitbucket, sin transformación.
     */
    @GetMapping("/{workspace}")
    public ResponseEntity<List<UserDTO>> getUsers(@PathVariable String workspace) {
        List<UserDTO> users = userService.fetchUsers(workspace);
        return ResponseEntity.ok(users);
    }

    /**
     * Extrae, transforma y envía los usuarios a GitMiner.
     */
    @PostMapping("/{workspace}/process")
    public ResponseEntity<String> processAndSendUsers(@PathVariable String workspace) {
        List<User> processedUsers = userService.processUsers(workspace);
        return ResponseEntity.ok("Usuarios procesados y enviados correctamente a GitMiner. Total: " + processedUsers.size());
    }
}