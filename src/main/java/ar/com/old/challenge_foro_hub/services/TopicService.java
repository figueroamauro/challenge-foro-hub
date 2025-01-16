package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.repositories.TopicRepository;
import ar.com.old.challenge_foro_hub.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public Page<Topic> findAll(Pageable pageable, String userName) {
        if (userName != null && !userName.isEmpty()) {
            return topicRepository.findAllByUserName(userName, pageable);
        }
        return topicRepository.findAll(pageable);
    }

    @Transactional
    public Topic save(Topic topic) {
        topic.setId(null);
        return topicRepository.save(topic);
    }

    public Topic findById(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return topic.get();
        }
        throw new RuntimeException("Topic not found");
    }


    public Topic update(Topic topic) {
        if (topic.getId() == null) {
            throw new RuntimeException("Topic not found");
        }
        Optional<Topic> tmpTopic = topicRepository.findById(topic.getId());
        if (tmpTopic.isPresent()) {
            if (topic.getTitle() != null) {
                tmpTopic.get().setTitle(topic.getTitle());
            }
            if (topic.getMessage() != null) {
                tmpTopic.get().setMessage(topic.getMessage());
            }
            return topicRepository.save(tmpTopic.get());
        }
        throw new RuntimeException("Topic not found");
    }


    @Transactional
    public void deleteById(Long id) {
        Optional<Topic> tmpTopic = topicRepository.findById(id);
        if (tmpTopic.isPresent()) {
            topicRepository.deleteById(id);
            return;
        }
        throw new RuntimeException("Topic not found");
    }

}
