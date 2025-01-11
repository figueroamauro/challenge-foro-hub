package ar.com.old.challenge_foro_hub.models.entitites;

public class User {
    private Long id;
    private String userName;
    private String password;
    private String email;

    public User(Long id, String name, String password, String email) {
        this.id = id;
        this.userName = name;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
