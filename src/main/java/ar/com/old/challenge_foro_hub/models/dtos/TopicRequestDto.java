package ar.com.old.challenge_foro_hub.models.dtos;

import jakarta.validation.constraints.NotNull;

public record TopicRequestDto(Long id, @NotNull String title, @NotNull String message, @NotNull Long userId) {
}
