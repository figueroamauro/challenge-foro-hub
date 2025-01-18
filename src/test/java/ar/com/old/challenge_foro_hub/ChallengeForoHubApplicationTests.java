package ar.com.old.challenge_foro_hub;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChallengeForoHubApplicationTests {
	public static void main(String[] args) {

	User user = new User(1L, "", "Password 1", "Email 1");
	}


}
