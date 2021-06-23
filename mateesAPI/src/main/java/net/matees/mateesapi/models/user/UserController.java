package net.matees.mateesapi.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public void addUserPost(@RequestParam(required = true) String username,
                            @RequestParam(required = true) String email,
                            @RequestParam(required = false) Integer age) {

        service.addNewUser(username, email, age);
    }

    @GetMapping
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return service.getAllUsers();
    }
}
