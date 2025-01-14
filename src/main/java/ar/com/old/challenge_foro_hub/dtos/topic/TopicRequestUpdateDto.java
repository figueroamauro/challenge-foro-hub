package ar.com.old.challenge_foro_hub.dtos.topic;

import jakarta.validation.constraints.NotNull;

public record TopicRequestUpdateDto(@NotNull Long id, String title, String message) {
}
