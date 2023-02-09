package ndtq.controller;


import ndtq.service.Tags.ITagService;
import ndtq.service.playlist.IPlaylistService;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
;



@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlayListController {
    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITagService tagService;
    @GetMapping()
    public ResponseEntity<Iterable<Playlist>> findAll() {
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Playlist>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playlistService.findById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody Playlist playlist, @PathVariable("id") Long id){
        playlist.setId(id);
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Long id){
        playlistService.remove(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
