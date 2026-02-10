package andreapascarella.u5d7homework.controllers;

import andreapascarella.u5d7homework.entities.User;
import andreapascarella.u5d7homework.payloads.NewUserPayload;
import andreapascarella.u5d7homework.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody NewUserPayload payload) {
        return this.usersService.saveUser(payload);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return this.usersService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return this.usersService.findById(userId);
    }

    @PutMapping("/{userId}")
    public User getUserByIdAndUpdate(@PathVariable long userId, @RequestBody NewUserPayload payload) {
        return this.usersService.findByIdAndUpdate(userId, payload);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void getUserByIdAndDelete(@PathVariable long userId) {
        this.usersService.findByIdAndDelete(userId);
    }

}
