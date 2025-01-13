package ar.com.old.challenge_foro_hub.models.dtos;

import ar.com.old.challenge_foro_hub.models.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public record TopicResponseDto(Long id, String title, String message, Status status, LocalDateTime creationDate, LocalDateTime lastUpdateDate, @JsonIgnore Long userId, String userName, String email) {

}