package andreapascarella.u5d7homework.services;

import andreapascarella.u5d7homework.entities.User;
import andreapascarella.u5d7homework.exceptions.NotFoundException;
import andreapascarella.u5d7homework.payloads.NewUserPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UsersService {
    private List<User> usersDB = new ArrayList<>();

    public List<User> findAllUsers() {
        return this.usersDB;
    }

    public User saveUser(NewUserPayload payload) {
        User newUser = new User(payload.getName(), payload.getSurname(),
                payload.getEmail(), payload.getBirthDate());
        this.usersDB.add(newUser);
        log.info("L'utente " + newUser.getId() + " è stato aggiunto correttamente");
        return newUser;
    }

    public User findById(long userId) {
        User found = null;
        for (User user : this.usersDB) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    public User findByIdAndUpdate(Long userId, NewUserPayload payload) {
        User found = null;
        for (User user : this.usersDB) {
            if (Objects.equals(user.getId(), userId)) {
                found = user;
                found.setName(payload.getName());
                found.setSurname(payload.getSurname());
                found.setEmail(payload.getEmail());
                found.setAvatar(payload.getAvatar());
                found.setBirthDate(payload.getBirthDate());
            }
        }
        if (found == null) throw new NotFoundException(userId);
        return found;
    }

    public void findByIdAndDelete(long userId) {
        User found = null;
        for (User user : this.usersDB) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException(userId);
        this.usersDB.remove(found);
    }
}
