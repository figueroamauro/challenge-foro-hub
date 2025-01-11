package ar.com.old.challenge_foro_hub.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @ParameterizedTest
    @NullSource
    void shouldFailUpdatingStatusAndThrowException_withNull(ResponseStatus responseStatus) {
        TopicResponse topicResponse = new TopicResponse(1L, "Message 1");

        Executable executable = () -> topicResponse.updateStatus(responseStatus);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Status cannot be null", exception.getMessage());

    }
}
