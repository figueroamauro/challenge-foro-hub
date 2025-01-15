package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByTopicId(Pageable pageable, Long topicId);

    @Query("SELECT c FROM Comment c WHERE c.topic.user.userName = ?1")
    Page<Comment> findAllByUserName(String userName, Pageable pageable);
}
