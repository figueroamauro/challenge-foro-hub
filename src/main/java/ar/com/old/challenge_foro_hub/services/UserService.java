package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new RuntimeException("User not found");
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        Optional<User> tmpUser = userRepository.findById(id);
        if (tmpUser.isPresent()) {
            userRepository.deleteById(id);
        }
        throw new RuntimeException("User not found");
    }

    public User update(User user) {
        Optional<User> tmpUser = userRepository.findById(user.getId());
        if (tmpUser.isPresent()) {
            return userRepository.save(tmpUser.get());
        }
        throw new RuntimeException("User not found");
    }


}
