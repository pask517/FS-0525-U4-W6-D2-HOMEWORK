package andreapascarella.u5d7homework.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatar;

    public User(String surname, String name, String email, LocalDate birthDate) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.avatar = "https://ui-avatars.com/api/?name=Pippo+Franco";
        Random rndm = new Random();
        this.id = rndm.nextLong(1, 1000);
    }
}
