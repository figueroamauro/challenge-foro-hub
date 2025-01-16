package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.dtos.comment.CommentRequestDto;
import ar.com.old.challenge_foro_hub.dtos.comment.CommentResponseDto;
import ar.com.old.challenge_foro_hub.mappers.comment.CommentRequestMapper;
import ar.com.old.challenge_foro_hub.mappers.comment.CommentResponseMapper;
import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import ar.com.old.challenge_foro_hub.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService topicCommentService) {
        this.commentService = topicCommentService;
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<CommentResponseDto>>> findAll(Pageable pageable,
                                                                               PagedResourcesAssembler<CommentResponseDto> pagedResourcesAssembler,
                                                                               @RequestParam(required = false) String userName,
                                                                               @RequestParam(required = false) Long topicId) {
        if (topicId == null && (userName == null || userName.isEmpty())) {
            throw new IllegalArgumentException("TopicId or userName is required");
        }
        Page<CommentResponseDto> comments = commentService.findAllByIdTopic(pageable, topicId, userName).map(CommentResponseMapper::toDto);
        return ResponseEntity.ok(pagedResourcesAssembler.toModel(comments));
    }

    @PostMapping
    public ResponseEntity<CommentResponseDto> save(@RequestBody @Valid CommentRequestDto dto) {
        Comment newComment = commentService.save(CommentRequestMapper.toEntity(dto));
        return ResponseEntity.ok(CommentResponseMapper.toDto(newComment));
    }

    @PutMapping
    public ResponseEntity<CommentResponseDto> update(@Valid @RequestBody CommentRequestDto dto) {
        Comment updatedComment = commentService.update(CommentRequestMapper.toEntity(dto));
        return ResponseEntity.ok(CommentResponseMapper.toDto(updatedComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
