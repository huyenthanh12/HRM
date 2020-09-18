package com.example.HRM.controllers.user;

import com.example.HRM.controllers.user.models.User;
import com.example.HRM.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@RequestBody @Validated User user) {

        return this.userMapper.toUser(
                this.userService.add(
                        this.userMapper.toUserEntity(user)
                )
        );
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return this.userMapper.toUser(
                this.userService.getById(id)
        );
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userMapper.toUsers(
                this.userService.getAllUsers()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id) {
        this.userService.deleteUserById(id);
    }
}
