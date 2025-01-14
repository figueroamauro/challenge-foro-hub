package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.models.entitites.TopicComment;
import ar.com.old.challenge_foro_hub.repositories.TopicCommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicCommentService {

    private TopicCommentRepository topicResponseRepository;

    public TopicComment findById(Long id) {
        Optional<TopicComment> topicResponse = topicResponseRepository.findById(id);
        if (topicResponse.isPresent()) {
            return topicResponse.get();
        }
        throw new RuntimeException("TopicResponse not found");
    }

    public Page<TopicComment> findAll(Pageable pageable) {
        return topicResponseRepository.findAll(pageable);
    }

    public TopicComment update(TopicComment topicResponse) {
        Optional<TopicComment> tmpTopicResponse = topicResponseRepository.findById(topicResponse.getId());
        if (tmpTopicResponse.isPresent()) {
            return topicResponseRepository.save(tmpTopicResponse.get());
        }
        throw new RuntimeException("TopicResponse not found");
    }

    public TopicComment save(TopicComment topicResponse) {
        return topicResponseRepository.save(topicResponse);
    }

    public void deleteById(Long id) {
        Optional<TopicComment> tmpTopicResponse = topicResponseRepository.findById(id);
        if (tmpTopicResponse.isPresent()) {
            topicResponseRepository.deleteById(id);
        }
        throw new RuntimeException("TopicResponse not found");
    }


}
