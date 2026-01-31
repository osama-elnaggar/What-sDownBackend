package group.el.de7k.WhatsDown.service;

import java.util.List;

import org.springframework.stereotype.Service;

import group.el.de7k.WhatsDown.Repository.UserRepository;
import group.el.de7k.WhatsDown.models.User;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
//idk does this appear useful?
    //map to a DTO later

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //map to a DTO later or check 7aga y3ny
    public void insertUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
}
