package group.el.de7k.WhatsDown.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginRequestDto {

    @Email
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;

    public UserLoginRequestDto() {
    }

    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
