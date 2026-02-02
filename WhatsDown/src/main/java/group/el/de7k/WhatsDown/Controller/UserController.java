package group.el.de7k.WhatsDown.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.el.de7k.WhatsDown.dto.UserRegisterRequestDto;
import group.el.de7k.WhatsDown.dto.UserResponoseDto;
import group.el.de7k.WhatsDown.models.User;
import group.el.de7k.WhatsDown.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        //this.authenticationService = authenticationService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

}
