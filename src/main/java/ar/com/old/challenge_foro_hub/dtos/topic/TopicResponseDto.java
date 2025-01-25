package ar.com.old.challenge_foro_hub.dtos.topic;

import ar.com.old.challenge_foro_hub.dtos.comment.CommentResponseDto;
import ar.com.old.challenge_foro_hub.enumerations.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponseDto(Long id, String title, String message, Status status, LocalDateTime creationDate, LocalDateTime lastUpdateDate, @JsonIgnore Long userId, String userName, String email, List<CommentResponseDto> comments) {

}
