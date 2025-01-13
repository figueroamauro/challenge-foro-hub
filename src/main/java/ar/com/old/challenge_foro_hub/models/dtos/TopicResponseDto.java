package ar.com.old.challenge_foro_hub.models.dtos;

import ar.com.old.challenge_foro_hub.models.Status;

import java.time.LocalDateTime;

public record TopicResponseDto(Long id, String title, String message, Status status, LocalDateTime creationDate, LocalDateTime lastUpdateDate, String userName, String email) {

}
