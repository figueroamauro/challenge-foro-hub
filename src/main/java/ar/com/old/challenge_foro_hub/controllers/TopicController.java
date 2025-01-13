package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.mappers.TopicRequestMapper;
import ar.com.old.challenge_foro_hub.mappers.TopicResponseMapper;
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
        return ResponseEntity.ok(topics.map(TopicResponseMapper::toDto));
    }

    @PostMapping
    public ResponseEntity<TopicResponseDto> save(@RequestBody TopicRequestDto topic) {
        Topic newTopic = topicService.save(TopicRequestMapper.toEntity(topic));
        return ResponseEntity.ok(TopicResponseMapper.toDto(newTopic));

    }


}
