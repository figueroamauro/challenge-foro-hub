package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
