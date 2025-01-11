package ar.com.old.challenge_foro_hub.models;


public class TopicResponse {
    private Long id;
    private String message;
    private ResponseStatus status;

    public TopicResponse(Long id, String message) {
        this.id = id;
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
        this.status = responseStatus;
    }
}
