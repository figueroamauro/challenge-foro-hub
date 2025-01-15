package ar.com.old.challenge_foro_hub.models.entitites;


import ar.com.old.challenge_foro_hub.models.CommentStatus;
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


    public Comment() {
        this.status = CommentStatus.ACCEPTED;
    }

    public Comment(String message, Topic topic) {
        this.topic = topic;
        this.message = message;
        this.status = CommentStatus.ACCEPTED;
    }

    public Comment(Long id,String message, Topic topic) {
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
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
