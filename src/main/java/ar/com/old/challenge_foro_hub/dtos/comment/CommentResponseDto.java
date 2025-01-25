package ar.com.old.challenge_foro_hub.dtos.comment;

import ar.com.old.challenge_foro_hub.enumerations.CommentStatus;

public record CommentResponseDto(Long id, String message, CommentStatus status,String userName) {
}
