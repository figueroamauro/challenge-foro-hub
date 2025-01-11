package ar.com.old.challenge_foro_hub.models.entitites;



import ar.com.old.challenge_foro_hub.models.Status;

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

    public Topic(User user, String title, String message) {
        this.id = null;
        this.title = title;
        this.message = message;
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = this.creationDate;
        this.responseList = new ArrayList<>();
        this.status = Status.OPEN;
        this.user = user;
    }

    public void addResponse(TopicResponse response) {
        this.responseList.add(response);
        this.updateLastUpdateDate();
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    private void updateLastUpdateDate() {
        this.lastUpdateDate = LocalDateTime.now();
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

    public List<TopicResponse> getResponseList() {
        return responseList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
