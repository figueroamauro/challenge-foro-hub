package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Page<Topic> findAll(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    @Transactional
    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic findById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return topic.get();
        }
        throw new RuntimeException("Topic not found");
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Topic> tmpTopic = topicRepository.findById(id);
        if (tmpTopic.isPresent()) {
            topicRepository.deleteById(id);
        }
        throw new RuntimeException("Topic not found");
    }

    @Transactional
    public Topic update(Topic topic) {
        Optional<Topic> tmpTopic = topicRepository.findById(topic.getId());
        if (tmpTopic.isPresent()) {

        return topicRepository.save(tmpTopic.get());
        }
        throw new RuntimeException("Topic not found");
    }
}
