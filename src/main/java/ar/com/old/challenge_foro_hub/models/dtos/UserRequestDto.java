package ar.com.old.challenge_foro_hub.models.dtos;


import jakarta.validation.constraints.NotNull;

public record UserRequestDto(Long id, @NotNull String userName, @NotNull String password, @NotNull String email) {
}