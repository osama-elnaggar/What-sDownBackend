package group.el.de7k.WhatsDown.dto;

public class UserResponoseDto {

    private Integer id;
    private String userName;
    private String profilePictureUrl;
    private String token;

    public UserResponoseDto() {
    }

    public UserResponoseDto(Integer id, String userName, String token, String profilePictureUrl) {
        this.id = id;
        this.userName = userName;
        this.token = token;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
