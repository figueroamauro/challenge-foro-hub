package ar.com.old.challenge_foro_hub.mappers.topic;

import ar.com.old.challenge_foro_hub.dtos.topic.TopicRequestDto;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class TopicRequestMapper {


    public static Topic toEntity(TopicRequestDto topicRequestDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new Topic(topicRequestDto.id(), user, topicRequestDto.title(), topicRequestDto.message());
    }
}
