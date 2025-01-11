package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
