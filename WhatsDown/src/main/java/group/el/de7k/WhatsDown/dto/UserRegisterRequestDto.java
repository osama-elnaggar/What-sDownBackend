package group.el.de7k.WhatsDown.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterRequestDto {

    @NotBlank(message = "invalid username")
    private String username;

    @NotBlank(message = "invalid password")
    @Size(min = 6, message = "password must be at least 6 characters long")
    private String password;

    @Email(message = "email must be valid")
    private String email;

    private String profilePictureUrl;

    public UserRegisterRequestDto() {
    }

    public UserRegisterRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    //probably maloho4 lazma bs why not
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    //probably maloho4 lazma bs why not
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    //probably maloho4 lazma bs why not
    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}
