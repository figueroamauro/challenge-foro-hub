package ar.com.old.challenge_foro_hub.models.dtos;

import org.springframework.lang.NonNull;

public record UserDTO(Long id, @NonNull String userName, @NonNull String password, @NonNull String email) {
}
