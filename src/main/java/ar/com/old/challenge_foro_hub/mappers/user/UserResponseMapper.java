package ar.com.old.challenge_foro_hub.mappers.user;

import ar.com.old.challenge_foro_hub.dtos.user.UserResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class UserResponseMapper {

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUserName(), user.getEmail());
    }


}
