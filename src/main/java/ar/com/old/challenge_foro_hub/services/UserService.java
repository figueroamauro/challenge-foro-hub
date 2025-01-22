package ar.com.old.challenge_foro_hub.services;

import ar.com.old.challenge_foro_hub.exceptions.UserNotFoundException;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("User not found");
    }

    public User save(User user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        Optional<User> tmpUser = userRepository.findById(id);
        if (tmpUser.isPresent()) {
            userRepository.deleteById(id);
            return;
        }
        throw new UserNotFoundException("User not found");
    }

    public User update(User user) {
        Optional<User> tmpUser = userRepository.findById(user.getId());
        if (tmpUser.isPresent()) {

            if (user.getUserName() != null) {
                tmpUser.get().setUserName(user.getUserName());
            }
            if (user.getPassword() != null) {
                String encodedPass = passwordEncoder.encode(user.getPassword());
                tmpUser.get().setPassword(encodedPass);
            }
            if (user.getEmail() != null) {
                tmpUser.get().setEmail(user.getEmail());
            }
            return userRepository.save(tmpUser.get());
        }
        throw new UserNotFoundException("User not found");
    }


}
