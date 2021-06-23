package net.matees.mateesapi.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //This will return the user
    public void addNewUser(String username,
                           String email,
                           Integer age) {
        //checks if the email is already taken
        if (userRepo.getUserByEmail(email).isPresent()) {
            throw new IllegalArgumentException("The email provieded" +
                    "has already been taken, please use another one");
        }

        User newUser = new User(
                username,
                age,
                email
        );

        userRepo.save(newUser);
    }

    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        userRepo.delete(
                userRepo.getUserById(id)
        );
    }
}
