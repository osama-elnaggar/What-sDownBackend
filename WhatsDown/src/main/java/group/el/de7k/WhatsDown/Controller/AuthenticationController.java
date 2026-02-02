package group.el.de7k.WhatsDown.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import group.el.de7k.WhatsDown.dto.UserRegisterRequestDto;
import group.el.de7k.WhatsDown.dto.UserResponoseDto;
import group.el.de7k.WhatsDown.service.AuthenticationService;
import group.el.de7k.WhatsDown.service.UserService;
import group.el.de7k.WhatsDown.dto.UserLoginRequestDto;
import group.el.de7k.WhatsDown.models.User;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;

    }

    @PostMapping("/register")
    public UserResponoseDto registerUser(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return userService.registerUser(userRegisterRequestDto);
    }

    @PostMapping("/login")
    public UserResponoseDto loginUser(@RequestBody UserLoginRequestDto loginRequest) {
        UserResponoseDto loggedUser = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        String token = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        loggedUser.setToken(token);
        return loggedUser;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }



}
