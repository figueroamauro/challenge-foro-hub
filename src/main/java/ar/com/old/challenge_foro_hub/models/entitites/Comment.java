package ar.com.old.challenge_foro_hub.models.entitites;


import ar.com.old.challenge_foro_hub.models.CommentStatus;
import ar.com.old.challenge_foro_hub.validators.CommentValidator;
import jakarta.persistence.*;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

  @Enumerated(EnumType.STRING)
    private CommentStatus status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "topic_id", referencedColumnName = "id")
  private Topic topic;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



    public Comment() {
        this.status = CommentStatus.ACCEPTED;
    }

    public Comment(String message, Topic topic, User user) {
        CommentValidator.validateMessage(message);
        this.user = user;
        this.topic = topic;
        this.message = message;
        this.status = CommentStatus.ACCEPTED;
    }

    public Comment(Long id,String message, Topic topic, User user) {
        CommentValidator.validateMessage(message);
        CommentValidator.validateId(id);
        this.user = user;
        this.id = id;
        this.topic = topic;
        this.message = message;
        this.status = CommentStatus.ACCEPTED;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void updateStatus(CommentStatus responseStatus) {
        if (responseStatus == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = responseStatus;
    }

    public void setId(Long id) {
        CommentValidator.validateId(id);
        this.id = id;
    }

    public void setMessage(String message) {
        CommentValidator.validateMessage(message);
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
