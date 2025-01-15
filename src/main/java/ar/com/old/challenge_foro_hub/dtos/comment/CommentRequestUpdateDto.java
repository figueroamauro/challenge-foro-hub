package ar.com.old.challenge_foro_hub.dtos.comment;

import jakarta.validation.constraints.NotNull;

public record CommentRequestUpdateDto(@NotNull Long id, String message) {
}
