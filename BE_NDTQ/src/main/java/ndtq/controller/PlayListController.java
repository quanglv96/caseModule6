package ndtq.controller;

import CaseStudy4.model.Playlist;
import CaseStudy4.model.Tags;
import CaseStudy4.model.Users;
import CaseStudy4.service.Tags.ITagService;
import CaseStudy4.service.playlist.IPlaylistService;
import CaseStudy4.service.users.IUserService;
import ndtq.service.Tags.ITagService;
import ndtq.service.playlist.IPlaylistService;
import ndtq.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlayListController {
    @Autowired
    private IPlaylistService iPlaylistService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITagService tagService;

}
