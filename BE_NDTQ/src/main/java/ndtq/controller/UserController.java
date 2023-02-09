package ndtq.controller;

import ndtq.model.Users;
import ndtq.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository iUserRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("pass") String pass) {
        Optional<Users> users = iUserRepository.findUserByUsername(username);
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
}


