package ar.com.old.challenge_foro_hub.controllers;

import ar.com.old.challenge_foro_hub.mappers.user.UserRequestMapper;
import ar.com.old.challenge_foro_hub.mappers.user.UserResponseMapper;
import ar.com.old.challenge_foro_hub.dtos.user.UserRequestDto;
import ar.com.old.challenge_foro_hub.dtos.user.UserResponseDto;
import ar.com.old.challenge_foro_hub.models.entitites.User;
import ar.com.old.challenge_foro_hub.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<PagedModel<?>> findAll(@PageableDefault(size = 10) Pageable pageable,PagedResourcesAssembler<UserResponseDto> pagedResourcesAssembler) {
        Page<UserResponseDto> users = userService.findAll(pageable).map(UserResponseMapper::toDto);
        return ResponseEntity.ok(pagedResourcesAssembler.toModel(users));
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(UserResponseMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto dto)  {
        User user = userService.save(UserRequestMapper.toEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(user.getId())
                               .toUri();
        return ResponseEntity.created(location).body(UserResponseMapper.toDto(user));
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> update(@Valid @RequestBody UserRequestDto dto) {
        User userContext = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = UserRequestMapper.toEntity(dto);
        user.setId(userContext.getId());
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(UserResponseMapper.toDto(updatedUser));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}