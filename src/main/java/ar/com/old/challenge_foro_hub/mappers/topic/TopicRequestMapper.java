package ar.com.old.challenge_foro_hub.mappers.topic;

import ar.com.old.challenge_foro_hub.dtos.topic.TopicRequestDto;
import ar.com.old.challenge_foro_hub.dtos.topic.TopicRequestUpdateDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;

public class TopicRequestMapper {

    public static Topic toEntity(TopicRequestUpdateDto topicRequestUpdateDto) {
        return new Topic(topicRequestUpdateDto.id(), null, topicRequestUpdateDto.title(), topicRequestUpdateDto.message());
    }

    public static Topic toEntity(TopicRequestDto topicRequestDto) {
        return new Topic(topicRequestDto.id(), new User(topicRequestDto.userId(), null, null, null), topicRequestDto.title(), topicRequestDto.message());
    }
}
