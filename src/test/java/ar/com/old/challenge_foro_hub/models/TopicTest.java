package ar.com.old.challenge_foro_hub.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TopicTest {

    @Test
    void shouldCreateInstance_withValidParams() {
        Topic topic = new Topic(1L, "Title 1", "Message 1", new User());

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
