package group.el.de7k.WhatsDown.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import group.el.de7k.WhatsDown.dto.UserRegisterRequestDto;
import group.el.de7k.WhatsDown.dto.UserResponoseDto;
import group.el.de7k.WhatsDown.service.AuthenticationService;
import group.el.de7k.WhatsDown.service.UserService;

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
    public UserResponoseDto loginUser(@RequestParam String email, @RequestParam String password) {
        UserResponoseDto loggedUser = userService.loginUser(email, password);
        String token = authenticationService.authenticate(email, password);
        loggedUser.setToken(token);
        return loggedUser;
    }

}
