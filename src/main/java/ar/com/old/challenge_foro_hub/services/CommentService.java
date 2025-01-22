package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.exceptions.CommentNotFoundException;
import ar.com.old.challenge_foro_hub.exceptions.TopicNotFoundException;
import ar.com.old.challenge_foro_hub.models.entitites.Comment;
import ar.com.old.challenge_foro_hub.models.entitites.Topic;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.repositories.CommentRepository;
import ar.com.old.challenge_foro_hub.repositories.TopicRepository;
import ar.com.old.challenge_foro_hub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;

    public Comment findById(Long id) {
        Optional<Comment> tmpComment = commentRepository.findById(id);
        if (tmpComment.isPresent()) {
            return tmpComment.get();
        }
        throw new CommentNotFoundException("Comment not found");
    }

    public Page<Comment> findAllByIdTopic(Pageable pageable,Long topicId, String userName) {
        if (isBlank(userName)) {
            return commentRepository.findAllByUserName(userName, pageable);
        }
        return commentRepository.findAllByTopicId(pageable, topicId);
    }


    @Transactional
    public Comment update(Comment comment) {
        Optional<Comment> tmpComment = commentRepository.findById(comment.getId());
        if (tmpComment.isPresent()) {
            if (comment.getMessage() != null) {
                tmpComment.get().setMessage(comment.getMessage());
            }
            return commentRepository.save(tmpComment.get());
        }
        throw new CommentNotFoundException("Comment not found");
    }

    @Transactional
    public Comment save(Comment comment) {
        Optional<Topic> topic = topicRepository.findById(comment.getTopic().getId());
        Optional<User> user = userRepository.findById(comment.getUser().getId());
        comment.setUser(user.get());
        if (topic.isPresent()) {
            comment.setTopic(topic.get());
            topic.get().addComment(comment);
            return commentRepository.save(comment);
        }
        throw new TopicNotFoundException("Topic not found");
    }

    public void deleteById(Long id) {
        Optional<Comment> tmpComment = commentRepository.findById(id);
        if (tmpComment.isPresent()) {
            commentRepository.deleteById(id);
        }
        throw new CommentNotFoundException("Comment not found");
    }


    private static boolean isBlank(String userName) {
        return userName != null && !userName.isEmpty();
    }
}
