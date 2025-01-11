package ar.com.old.challenge_foro_hub.models;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void shouldCreateInstance_withValidParams() {
        User user = new User(1L, "Username 1", "Password 1", "Email 1");

        assertEquals(1L, user.getId());
        assertEquals("Username 1", user.getUserName());
        assertEquals("Password 1", user.getPassword());
        assertEquals("Email 1", user.getEmail());

    }
}
