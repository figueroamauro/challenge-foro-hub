package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUserName(String username);
}
