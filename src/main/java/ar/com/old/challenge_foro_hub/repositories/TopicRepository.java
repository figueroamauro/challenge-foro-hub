package ar.com.old.challenge_foro_hub.repositories;

import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t FROM Topic t WHERE t.user.userName = ?1")
    Page<Topic> findAllByUserName(String userName, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM Topic t WHERE t.id = ?1")
    void deleteTopicById(Long aLong);
}
