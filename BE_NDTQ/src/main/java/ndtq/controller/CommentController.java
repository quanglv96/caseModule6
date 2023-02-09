package ndtq.controller;

import CaseStudy4.model.Comments;
import CaseStudy4.service.Songs.ISongService;
import CaseStudy4.service.comment.ICommentService;
import CaseStudy4.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;
    @Autowired
    private ISongService iSongService;
    @Autowired
    private IPlaylistService iPlaylistService;

    @GetMapping("/song/{id}")
    public ResponseEntity<Iterable<Comments>> listCommentInSong(@PathVariable Long id) {
        return new ResponseEntity<>(iCommentService.findAllBySongsOrderByDateDesc(iSongService.findById(id).get()), HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<Iterable<Comments>> listCommentInPlaylist(@RequestBody Long id) {
        return new ResponseEntity<>(iCommentService.findAllByPlaylistOrderByDateDesc(iPlaylistService.findById(id).get()), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteComment(@RequestBody Long id) {
        iCommentService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Iterable<Comments>> save(@RequestBody Comments comments) {
        LocalDateTime date = LocalDateTime.now();
        comments.setDate(date);
        iCommentService.save(comments);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
