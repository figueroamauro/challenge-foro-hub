package ar.com.old.challenge_foro_hub.models;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Topic {
    private Long id;
    private String title;
    private String message;
    private Status status;
    private final LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private final List<TopicResponse> responseList;
    private User user;

    public Topic(Long id, String title, String message, User user) {
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
        this.responseList = new ArrayList<>();
        this.id = id;
        this.title = title;
        this.message = message;
        this.status = Status.OPEN;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public List<Response> getResponseList() {
        return responseList;
    }
}
