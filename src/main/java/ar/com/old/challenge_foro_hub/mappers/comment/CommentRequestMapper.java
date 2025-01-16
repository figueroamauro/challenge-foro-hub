package ar.com.old.challenge_foro_hub.mappers.comment;

import ar.com.old.challenge_foro_hub.dtos.comment.CommentRequestDto;
import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class CommentRequestMapper {
    public static Comment toEntity(CommentRequestDto dto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getUserName());
        return new Comment(dto.message(), new Topic(dto.topicId(),user,null,null), user);
    }

}