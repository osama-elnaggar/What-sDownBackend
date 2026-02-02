package group.el.de7k.WhatsDown.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import group.el.de7k.WhatsDown.Security.JwtService;
import group.el.de7k.WhatsDown.dto.AuthenticationRequest;
import group.el.de7k.WhatsDown.dto.AuthenticationResponse;

@Service
public class AuthenticationService {

    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(String email, String password) {
        authenticationManager.authenticate(
                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(email, password)
        );
        var token = jwtService.generateToken(
                //no extra claims
                new org.springframework.security.core.userdetails.User(email, password, new java.util.ArrayList<>())
        );
        return token;

    }
}
