package ar.com.old.challenge_foro_hub.models;

import static org.junit.jupiter.api.Assertions.*;

import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.junit.jupiter.api.Test;


public class TopicTest {

    @Test
    void shouldCreateInstance_withValidParams() {
        Topic topic = new Topic(1L, "Title 1", "Message 1",
                new User(1L, "test", "test", "test"));

        assertEquals(1L, topic.getId());
        assertEquals("Title 1", topic.getTitle());
        assertEquals("Message 1", topic.getMessage());
        assertEquals(Status.OPEN, topic.getStatus());
        assertNotNull(topic.getCreationDate());
        assertNotNull(topic.getLastUpdateDate());
        assertNotNull(topic.getResponseList());
        assertNotNull(topic.getUser());

    }
}
