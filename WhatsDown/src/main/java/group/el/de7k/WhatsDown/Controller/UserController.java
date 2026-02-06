package group.el.de7k.WhatsDown.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.el.de7k.WhatsDown.Repository.UserRepository;
import group.el.de7k.WhatsDown.models.User;
import group.el.de7k.WhatsDown.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {

        userService.getAllUsers().forEach(user -> {
            System.out.println("User: " + user.getEmail());
        });
        return userRepository.findAll();

    }

    @GetMapping("/users/{id}")
    public User getUserById(@RequestParam String id) {
        return userService.getUserById(id);
    }

}
