package ar.com.old.challenge_foro_hub.dtos.comment;

import jakarta.validation.constraints.NotNull;

public record CommentRequestDto(@NotNull Long topicId, @NotNull String message) {
}
