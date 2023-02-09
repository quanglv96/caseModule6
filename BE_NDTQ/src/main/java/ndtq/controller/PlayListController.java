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
    private IPlaylistService iPlaylistService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ITagService tagService;

}
