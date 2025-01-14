package ar.com.old.challenge_foro_hub.dtos.user;

import jakarta.validation.constraints.NotNull;

public record UserRequestUpdateDto(@NotNull Long id, String userName, String password, String email) {
}
