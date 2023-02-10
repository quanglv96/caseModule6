package ndtq.controller;

import ndtq.model.Users;
import ndtq.repository.IUserRepository;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository iUserRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("pass") String pass) {
        Optional<Users> users = userService.findUserByUsername(username);
        if (users.isPresent()) {
            if (Objects.equals(pass, users.get().getPassword())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Wrong Password", HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<>("Username is not Present", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Users>> getAllUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        if(userService.checkUsername(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id,
                                            @RequestBody Users user) {
        Optional<Users> users = userService.findById(id);
        if(users.isPresent()) {
            user.setId(users.get().getId());
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getAllUsername() {
        return new ResponseEntity<>(userService.findAllUsername(), HttpStatus.OK);
    }
}