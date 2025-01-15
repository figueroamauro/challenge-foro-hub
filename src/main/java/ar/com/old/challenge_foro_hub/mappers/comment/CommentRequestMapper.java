package ar.com.old.challenge_foro_hub.mappers.comment;

import ar.com.old.challenge_foro_hub.dtos.comment.CommentRequestDto;
import ar.com.old.challenge_foro_hub.dtos.comment.CommentRequestUpdateDto;
import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;

public class CommentRequestMapper {

    public static Comment toEntity(CommentRequestDto topicCommentRequestDto) {
        return new Comment(topicCommentRequestDto.message(), new Topic(topicCommentRequestDto.topicId(), null, null, null));
    }

    public static Comment toEntity(CommentRequestUpdateDto commentRequestUpdateDto) {
        return new Comment(commentRequestUpdateDto.id(),commentRequestUpdateDto.message(), null);
    }
}