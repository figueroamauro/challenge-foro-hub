package ar.com.old.challenge_foro_hub.mappers;

import ar.com.old.challenge_foro_hub.models.dtos.UserRequestDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class UserRequestMapper {

    public static UserRequestDto toDto(User user) {
        return new UserRequestDto(user.getId(), user.getUserName(), user.getPassword(), user.getEmail());
    }

    public static User toEntity(UserRequestDto userRequestDto) {
        return new User(userRequestDto.id(), userRequestDto.userName(), userRequestDto.password(), userRequestDto.email());
    }
}
