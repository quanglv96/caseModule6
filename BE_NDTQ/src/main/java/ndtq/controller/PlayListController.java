package ndtq.controller;


import ndtq.model.Playlist;
import ndtq.model.Tags;
import ndtq.model.Users;
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

}
