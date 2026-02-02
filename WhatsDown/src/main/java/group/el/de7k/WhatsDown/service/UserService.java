package group.el.de7k.WhatsDown.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import group.el.de7k.WhatsDown.models.Role;

import group.el.de7k.WhatsDown.Repository.UserRepository;
import group.el.de7k.WhatsDown.dto.UserRegisterRequestDto;
import group.el.de7k.WhatsDown.dto.UserResponoseDto;
import group.el.de7k.WhatsDown.models.User;
import group.el.de7k.WhatsDown.Security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import group.el.de7k.WhatsDown.service.AuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        //this.jwtService = jwtService;
        //this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        //this.passwordEncoder = passwordEncoder;
    }

    public UserResponoseDto registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        if (userRepository.findByEmail(userRegisterRequestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = new User();
        user.setName(userRegisterRequestDto.getUsername());
        user.setEmail(userRegisterRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequestDto.getPassword()));
        user.setProfilePictureUrl(userRegisterRequestDto.getProfilePictureUrl());
        user.setRole(Role.USER);
        User savedUser = userRepository.save(user);

        //var token = jwtService.generateToken(savedUser);
        return new UserResponoseDto(savedUser.getId(), savedUser.getName(), null, savedUser.getProfilePictureUrl());
    }

    public UserResponoseDto loginUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        //for easier han2ol kda (m4 2ader)
        return new UserResponoseDto(user.getId(), user.getName(), null, user.getProfilePictureUrl());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }

    // public void insertUser(User user) {
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     userRepository.save(user);
    // }
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    public String saveProfilePictureUrl(String userId, String profilePictureUrl) {
        User user = getUserById(userId);
        user.setProfilePictureUrl(profilePictureUrl);
        userRepository.save(user);
        return profilePictureUrl;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch user from DB
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Convert Role to GrantedAuthority
        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );

        // Return Spring Security User
        return org.springframework.security.core.userdetails.User.builder() //el zena dh required 3ala4an spring boot 3ando user class
                .username(user.getEmail())
                .password(user.getPassword()) // Keep this for login; if using JWT only, can be empty
                .authorities(authorities)
                .build();
    }

}
