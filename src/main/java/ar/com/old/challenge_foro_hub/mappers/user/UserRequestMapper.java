package ar.com.old.challenge_foro_hub.mappers.user;

import ar.com.old.challenge_foro_hub.dtos.user.UserRequestDto;
import ar.com.old.challenge_foro_hub.dtos.user.UserRequestUpdateDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class UserRequestMapper {

    public static User toEntity(UserRequestDto userRequestDto) {
        return new User(null,userRequestDto.userName(), userRequestDto.password(), userRequestDto.email());
    }

    public static User toEntity(UserRequestUpdateDto userRequestDto) {
        return new User(userRequestDto.id(), userRequestDto.userName(), userRequestDto.password(), userRequestDto.email());
    }
}
