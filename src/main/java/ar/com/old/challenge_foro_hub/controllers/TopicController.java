package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.models.dtos.TopicRequestDto;
import ar.com.old.challenge_foro_hub.models.dtos.TopicResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<Page<TopicResponseDto>> finAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<Topic> topics = topicService.findAll(pageable);
        return ResponseEntity.ok(mapToTopicResponseDto(topics));
    }

    @PostMapping
    public ResponseEntity<TopicResponseDto> save(@RequestBody TopicRequestDto topic) {
        Topic newTopic = topicService.save(new Topic(null, topic.title(), topic.message()), topic.userId());
        return ResponseEntity.ok(new TopicResponseDto(newTopic.getId(),
                newTopic.getTitle(),
                newTopic.getMessage(),
                newTopic.getStatus(),
                newTopic.getCreationDate(),
                newTopic.getLastUpdateDate(),
                newTopic.getUser().getUserName(),
                newTopic.getUser().getEmail()));
    }


    private Page<TopicResponseDto> mapToTopicResponseDto(Page<Topic> all) {
        return all.map(topic -> new TopicResponseDto(topic.getId(), topic.getTitle(), topic.getMessage(),topic.getStatus(),
                topic.getCreationDate(),
                topic.getLastUpdateDate(),
                topic.getUser().getUserName(),
                topic.getUser().getEmail()));
    }
}
