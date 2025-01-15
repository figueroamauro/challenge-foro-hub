package ar.com.old.challenge_foro_hub.dtos.comment;

import ar.com.old.challenge_foro_hub.models.CommentStatus;

public record CommentResponseDto(Long id, String message, CommentStatus status,String userName) {
}
