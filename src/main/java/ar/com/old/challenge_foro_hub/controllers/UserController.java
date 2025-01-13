package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.models.dtos.UserRequestDto;
import ar.com.old.challenge_foro_hub.models.dtos.UserResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
       return ResponseEntity.ok(mapToPageResponseDTO(userService.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(new UserResponseDto(user.getId(), user.getUserName(),user.getEmail()));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto userDTO)  {
        User user = userService.save(new User(null, userDTO.userName(), userDTO.password(), userDTO.email()));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(user.getId())
                               .toUri();
        return ResponseEntity.created(location).body(new UserResponseDto(user.getId(), user.getUserName(),user.getEmail()));
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(@RequestBody UserRequestDto userDTO) {
        User user = userService.update(new User(userDTO.id(), userDTO.userName(), userDTO.password(), userDTO.email()));
        return ResponseEntity.ok(new UserResponseDto(user.getId(), user.getUserName(),user.getEmail()));
    }

    private Page<UserResponseDto> mapToPageResponseDTO(Page<User> all) {
        return all.map(user -> new UserResponseDto(user.getId(), user.getUserName(),user.getEmail()));
    }
}