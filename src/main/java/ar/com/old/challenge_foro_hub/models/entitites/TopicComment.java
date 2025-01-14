package ar.com.old.challenge_foro_hub.models.entitites;


import ar.com.old.challenge_foro_hub.models.ResponseStatus;
import jakarta.persistence.*;


@Entity
@Table(name = "topic_response")
public class TopicComment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

  @Enumerated(EnumType.STRING)
    private ResponseStatus status;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "topic_id", referencedColumnName = "id")
  private Topic topic;


    public TopicComment() {
        this.status = ResponseStatus.PENDING;
    }

    public TopicComment(String message) {
        this.message = message;
        this.status = ResponseStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void updateStatus(ResponseStatus responseStatus) {
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
