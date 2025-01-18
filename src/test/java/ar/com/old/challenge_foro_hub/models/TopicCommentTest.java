package ar.com.old.challenge_foro_hub.models;

import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TopicCommentTest {

    @Test
    void shouldCreateInstance_withValidParams() {
        Comment topicResponse = new Comment(1L, "Message 1",null,null);

        assertEquals(1L, topicResponse.getId());
        assertEquals("Message 1", topicResponse.getMessage());
        assertEquals(CommentStatus.PENDING, topicResponse.getStatus());
    }

    @Test
    void shouldUpdateStatus() {
        Comment topicResponse = new Comment(1L, "Message 1",null,null);

        topicResponse.updateStatus(CommentStatus.ACCEPTED);
        assertEquals(CommentStatus.ACCEPTED, topicResponse.getStatus());
    }

    @ParameterizedTest
    @NullSource
    void shouldFailUpdatingStatusAndThrowException_withNull(CommentStatus responseStatus) {
        Comment topicResponse = new Comment(1L, "Message 1",null,null);

        Executable executable = () -> topicResponse.updateStatus(responseStatus);
        Exception exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Status cannot be null", exception.getMessage());

    }

    @ParameterizedTest
    @ValueSource(strings = {"Message 10", "Message 20", "Message 30"})
    void shouldSetNewMessage(String message) {
        Comment topicResponse = new Comment(1L, "Message 1",null,null);
        topicResponse.setMessage(message);
        assertEquals(message, topicResponse.getMessage());
    }
}
