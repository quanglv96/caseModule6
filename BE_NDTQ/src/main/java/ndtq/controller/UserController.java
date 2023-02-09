package ndtq.controller;

import ndtq.model.Users;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping()
    public ResponseEntity<Iterable<Users>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        if (userService.checkUsername(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}
