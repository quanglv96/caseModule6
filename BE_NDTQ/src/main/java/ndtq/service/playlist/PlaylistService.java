package ndtq.service.playlist;


import ndtq.model.Playlist;
import ndtq.model.Tags;
import ndtq.model.Users;
import ndtq.repository.IPlaylistRepository;
import ndtq.service.Tags.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlaylistService implements IPlaylistService{
    @Autowired
    private IPlaylistRepository iPlaylistRepository;
    @Autowired
    private ITagService tagService;
    @Override
    public Iterable<Playlist> findAll() {
        iPlaylistRepository.setViewsAllPlaylist();
        return iPlaylistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return iPlaylistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        List<Tags> tagsList = playlist.getTagsList();
        iPlaylistRepository.save(playlist);
        for (int i = 0; i <  tagsList.size(); i++) {
            tagService.addPlaylistTag(playlist.getId(),tagsList.get(i).getId());
        }
        return iPlaylistRepository.save(playlist);
    }

    @Override
    public void remove(Long id) {
        iPlaylistRepository.deletePlaylistInSongs(id);
        iPlaylistRepository.deletePlaylistInTag(id);
        iPlaylistRepository.deleteById(id);
    }

    @Override
    public Iterable<Playlist> listTrending() {
        return iPlaylistRepository.findAllByOrderByViewsDesc();
    }

    @Override
    public Iterable<Playlist> listNewPlaylist() {
        return iPlaylistRepository.findAllByOrderByDateCreateDesc();
    }

    @Override
    public Iterable<Playlist> findAllByUsers(Users users) {
        return iPlaylistRepository.findAllByUsers(users);
    }

    @Override
    public Iterable<Playlist> findAllByNameContaining(String name) {
        return iPlaylistRepository.findAllByNameContaining(name);
    }
}
