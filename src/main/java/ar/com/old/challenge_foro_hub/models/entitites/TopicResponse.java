package ar.com.old.challenge_foro_hub.models.entitites;


import ar.com.old.challenge_foro_hub.models.ResponseStatus;

public class TopicResponse {
    private Long id;
    private String message;
    private ResponseStatus status;

    public TopicResponse( String message) {
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
}
