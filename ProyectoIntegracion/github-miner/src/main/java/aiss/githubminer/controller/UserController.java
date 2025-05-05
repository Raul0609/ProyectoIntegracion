package aiss.githubminer.controller;

import aiss.githubminer.service.UserService;
import aiss.githubminer.model.UserDTO;
import aiss.gitminer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 🔹 Obtiene los detalles de un usuario en GitHub, sin transformación.
     */
    @GetMapping("/github/{username}")
    public ResponseEntity<UserDTO> getGitHubUser(@PathVariable String username) {
        UserDTO user = userService.fetchUser(username);
        return ResponseEntity.ok(user);
    }

    /**
     * 🔹 Extrae, transforma y envía la información del usuario a GitMiner.
     */
    @PostMapping("/{username}/process")
    public ResponseEntity<String> processAndSendUser(@PathVariable String username) {
        User processedUser = userService.processUser(username);
        return ResponseEntity.ok("Usuario procesado y enviado correctamente a GitMiner: " + processedUser.getUsername());
    }
}