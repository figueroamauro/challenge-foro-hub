package ar.com.old.challenge_foro_hub.mappers;

import ar.com.old.challenge_foro_hub.models.dtos.TopicResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class TopicResponseMapper {
    public static TopicResponseDto toDto(Topic topic) {
        return new TopicResponseDto(topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getStatus(),
                topic.getCreationDate(),
                topic.getLastUpdateDate(),
                topic.getUser().getId(),
                topic.getUser().getUserName(),
                topic.getUser().getEmail());
    }

}
