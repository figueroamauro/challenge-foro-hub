package ar.com.old.challenge_foro_hub.models.entitites;



import ar.com.old.challenge_foro_hub.enumerations.Status;
import ar.com.old.challenge_foro_hub.validators.TopicValidator;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "creation_date")
    private final LocalDateTime creationDate;

    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "topic", orphanRemoval = true)
    private final List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Topic() {
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = this.creationDate;
        this.comments = new ArrayList<>();
        this.status = Status.OPEN;
    }

    public Topic(Long id,User user, String title, String message) {
        TopicValidator.validateTitle(title);
        TopicValidator.validateMessage(message);
        TopicValidator.validateId(id);

        this.id = id;
        this.title = title;
        this.message = message;
        this.creationDate = LocalDateTime.now();
        this.lastUpdateDate = this.creationDate;
        this.comments = new ArrayList<>();
        this.status = Status.OPEN;
        this.user = user;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setTopic(this);
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setId(Long id) {
        TopicValidator.validateId(id);
        this.id = id;
    }

    public void setTitle(String title) {
        TopicValidator.validateTitle(title);
        this.title = title;
    }

    public void setMessage(String message) {
        TopicValidator.validateMessage(message);
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
