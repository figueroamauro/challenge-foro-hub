package ar.com.old.challenge_foro_hub.mappers;

import ar.com.old.challenge_foro_hub.models.dtos.TopicRequestDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class TopicRequestMapper {

    public static TopicRequestDto toDto(Topic topic) {
        return new TopicRequestDto(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getUser().getId());
    }

    public static Topic toEntity(TopicRequestDto topicRequestDto) {
        return new Topic(new User(topicRequestDto.userId(), null, null, null), topicRequestDto.title(), topicRequestDto.message());
    }
}
