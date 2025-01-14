package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.TopicComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicCommentRepository extends JpaRepository<TopicComment, Long> {
}
