package ndtq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data

@AllArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description; // mô tả nội dung bài hát
    private String avatar;
    private LocalDate dateCreate; // ngày tạo
    private LocalDate lastUpdate;
    @Transient
    private String stringTag;
    // ngày cập nhập lần cuối
    @NotNull
    @OneToOne(targetEntity = Users.class)
    @JoinColumn(name = "id_users")
    private Users users;// ngươi tạo playlist
    @ManyToMany(targetEntity = Songs.class)
    @JoinTable(name = "playlist_song",joinColumns = {@JoinColumn(name = "id_playlist")},
            inverseJoinColumns = {@JoinColumn(name = "id_songs")})
    private List<Songs> songsList;
    @ManyToMany(targetEntity = Tags.class)
    @JoinTable( name = "playlist_tag",
            joinColumns = {@JoinColumn(name = "id_playlist")},
            inverseJoinColumns = {@JoinColumn(name = "id_tags")})
    private List<Tags> tagsList;
    private long views;
    private long likes;

    public Playlist(String name, String description, LocalDate dateCreate, LocalDate lastUpdate, Users users, List<Songs> songsList, List<Tags> tagsList, long views, long likes) {
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
        this.songsList = songsList;
        this.tagsList = tagsList;
        this.views = views;
        this.likes = likes;
    }

    public Playlist(String name, String description, String avatar, LocalDate dateCreate, LocalDate lastUpdate, Users users) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
    }

    public Playlist(String name, String description, String avatar, LocalDate dateCreate, LocalDate lastUpdate, Users users, List<Tags> tagsList, long views, long likes) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
        this.tagsList = tagsList;
        this.views = views;
        this.likes = likes;
    }

    public Playlist(String name, String description, String avatar, LocalDate dateCreate, LocalDate lastUpdate, Users users, long views, long likes) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
        this.views = views;
        this.likes = likes;
    }

    public Playlist(Long id, String name, String description, String avatar, LocalDate dateCreate, LocalDate lastUpdate, Users users, List<Songs> songsList, List<Tags> tagsList, long views, long likes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
        this.songsList = songsList;
        this.tagsList = tagsList;
        this.views = views;
        this.likes = likes;
    }

    public Playlist(String name, String description, String avatar, LocalDate dateCreate, LocalDate lastUpdate, Users users, List<Songs> songsList, List<Tags> tagsList, long views, long likes) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.dateCreate = dateCreate;
        this.lastUpdate = lastUpdate;
        this.users = users;
        this.songsList = songsList;
        this.tagsList = tagsList;
        this.views = views;
        this.likes = likes;
    }

    public Playlist() {
    }

    @Transient
    private MultipartFile image;
}
