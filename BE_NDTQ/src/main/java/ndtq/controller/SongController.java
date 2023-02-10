package ndtq.controller;


import ndtq.model.*;
import ndtq.service.Singer.ISingerService;
import ndtq.service.Songs.ISongService;
import ndtq.service.Tags.ITagService;
import ndtq.service.comment.ICommentService;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @Autowired
    private ISingerService singerService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IUserService userService;

    @PostMapping("/listNewSongs")
    public ResponseEntity<Iterable<Songs>> listNewSongsByDate() {
        return new ResponseEntity<>(iSongService.listNewSongs(), HttpStatus.OK);
    }
    @PostMapping("/listSongsTrending")
    public ResponseEntity<Iterable<Songs>> listSongsTrendingByView() {
        return new ResponseEntity<>(iSongService.listTrending(), HttpStatus.OK);
    }
    @PostMapping("/listSongsTrendingAsc")
    public ResponseEntity<Iterable<Songs>> listSongsTrendingByViewAsc() {
        return new ResponseEntity<>(iSongService.listTrendingAsc(), HttpStatus.OK);
    }
}


