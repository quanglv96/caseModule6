package ndtq.controller;


import ndtq.model.Songs;
import ndtq.model.Users;
import ndtq.service.Singer.ISingerService;
import ndtq.service.Songs.ISongService;
import ndtq.service.Tags.ITagService;
import ndtq.service.comment.ICommentService;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;
    @Autowired
    private ISingerService singerService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IUserService userService;

    @GetMapping()
    public ResponseEntity<Iterable<Songs>> findAll() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Songs>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Songs songs){
        return new ResponseEntity<>(songService.save(songs), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Songs songs, @PathVariable("id") Long id){
        songs.setId(id);
        return new ResponseEntity<>(songService.save(songs),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id){
        songService.remove(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}


