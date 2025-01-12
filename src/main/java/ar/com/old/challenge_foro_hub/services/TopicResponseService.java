package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.models.entitites.TopicResponse;
import ar.com.old.challenge_foro_hub.repositories.TopicResponseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicResponseService {

    private TopicResponseRepository topicResponseRepository;

    public TopicResponse findById(Long id) {
        Optional<TopicResponse> topicResponse = topicResponseRepository.findById(id);
        if (topicResponse.isPresent()) {
            return topicResponse.get();
        }
        throw new RuntimeException("TopicResponse not found");
    }

    public Page<TopicResponse> findAll(Pageable pageable) {
        return topicResponseRepository.findAll(pageable);
    }

    public TopicResponse update(TopicResponse topicResponse) {
        Optional<TopicResponse> tmpTopicResponse = topicResponseRepository.findById(topicResponse.getId());
        if (tmpTopicResponse.isPresent()) {
            return topicResponseRepository.save(tmpTopicResponse.get());
        }
        throw new RuntimeException("TopicResponse not found");
    }

    public TopicResponse save(TopicResponse topicResponse) {
        return topicResponseRepository.save(topicResponse);
    }

    public void deleteById(Long id) {
        Optional<TopicResponse> tmpTopicResponse = topicResponseRepository.findById(id);
        if (tmpTopicResponse.isPresent()) {
            topicResponseRepository.deleteById(id);
        }
        throw new RuntimeException("TopicResponse not found");
    }


}
