package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.mappers.TopicRequestMapper;
import ar.com.old.challenge_foro_hub.mappers.TopicResponseMapper;
import ar.com.old.challenge_foro_hub.models.dtos.TopicRequestDto;
import ar.com.old.challenge_foro_hub.models.dtos.TopicRequestUpdateDto;
import ar.com.old.challenge_foro_hub.models.dtos.TopicResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.services.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<TopicResponseDto>>> finAll(@PageableDefault(size = 10) Pageable pageable,
                                                                            PagedResourcesAssembler<TopicResponseDto> pagedResourcesAssembler) {
        Page<TopicResponseDto> topics = topicService.findAll(pageable).map(TopicResponseMapper::toDto);

        return ResponseEntity.ok(pagedResourcesAssembler.toModel(topics));
    }

    @PostMapping
    public ResponseEntity<TopicResponseDto> save(@RequestBody TopicRequestDto topic) {
        Topic newTopic = topicService.save(TopicRequestMapper.toEntity(topic));
        return ResponseEntity.ok(TopicResponseMapper.toDto(newTopic));

    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDto> findById(@PathVariable Long id) {
        Topic topic = topicService.findById(id);
        return ResponseEntity.ok(TopicResponseMapper.toDto(topic));
    }

    @PutMapping
    public ResponseEntity<TopicResponseDto> update(@RequestBody TopicRequestUpdateDto dto) {
        Topic updatedTopic = topicService.update(TopicRequestMapper.toEntity(dto));
        return ResponseEntity.ok(TopicResponseMapper.toDto(updatedTopic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        topicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
