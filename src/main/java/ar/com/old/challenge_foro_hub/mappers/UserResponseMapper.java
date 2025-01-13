package ar.com.old.challenge_foro_hub.mappers;

import ar.com.old.challenge_foro_hub.models.dtos.UserResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class UserResponseMapper {

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getUserName(), user.getEmail());
    }


}
