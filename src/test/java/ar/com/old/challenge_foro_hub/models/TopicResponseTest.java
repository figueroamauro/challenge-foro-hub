package ar.com.old.challenge_foro_hub.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopicResponseTest {

    @Test
    void shouldCreateInstance_withValidParams() {
        TopicResponse topicResponse = new TopicResponse(1L, "Message 1");

        assertEquals(1L, topicResponse.getId());
        assertEquals("Message 1", topicResponse.getMessage());
        assertEquals(ResponseStatus.PENDING, topicResponse.getStatus());
    }

    @Test
    void shouldUpdateStatus() {
        TopicResponse topicResponse = new TopicResponse(1L, "Message 1");

        topicResponse.updateStatus(ResponseStatus.APPROVED);
        assertEquals(ResponseStatus.APPROVED, topicResponse.getStatus());
    }
}
