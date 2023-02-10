package ndtq.service.Songs;


import ndtq.model.Singer;
import ndtq.model.Songs;
import ndtq.model.Tags;
import ndtq.model.Users;
import ndtq.repository.ISongRepository;
import ndtq.service.Singer.ISingerService;
import ndtq.service.Tags.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository isongRepository;
    @Autowired
    private ITagService tagService;
    @Autowired
    private ISingerService singerService;

    @Override
    public Iterable<Songs> findAll() {
        isongRepository.setViewsAllSong();
        return isongRepository.findAll();
    }
    @Override
    public Iterable<Songs> listTrending() {
        return isongRepository.findAllByOrderByViewsDesc();
    }
    @Override
    public Iterable<Songs> listTrendingAsc() {
        return isongRepository.findAllByOrderByViewsAsc();
    }

    @Override
    public Iterable<Songs> findAllByNameContaining(String name) {
        return isongRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Songs> listNewSongs() {
        return isongRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Iterable<Songs> findAllByUsers(Users users) {
        return isongRepository.findAllByUsers(users);
    }


    @Override
    public Optional<Songs> findById(Long id) {
        return isongRepository.findById(id);
    }

    @Override
    public Songs save(Songs songs) {
        isongRepository.save(songs);
//        Songs newSong=isongRepository.findByName(songs.getName()).get();
        List<Tags> tagsList = songs.getTagsList();
        for (int i = 0; i <  tagsList.size(); i++) {
            tagService.addSongTag(songs.getId(),tagsList.get(i).getId());
        }
        List<Singer> listSinger=songs.getSingerList();
        for (int i = 0; i < listSinger.size(); i++) {
            singerService.addSingerSong(songs.getId(),listSinger.get(i).getId());
        }
        return isongRepository.save(songs);
    }

    @Override
    public void remove(Long id) {
        isongRepository.deleteSongInPlaylist(id);
        isongRepository.deleteSongInTag(id);
        isongRepository.deleteSongInSinger(id);
        isongRepository.deleteById(id);
    }

    @Override
    public Iterable<Songs> findAllBySingerList(Long id) {
        return isongRepository.findAllBySingerList(id);
    }

    @Override
    public List<Songs> generateFiveRandom(Long id) {
        List<Songs> result = new ArrayList<>();
        List<Songs> songsList = (List<Songs>) findAll();
        Set<Integer> indexes = new HashSet<>();
        while (indexes.size() <= 4) {
            Random rand = new Random();
            int index = rand.nextInt(songsList.size());
            if (Objects.equals(songsList.get(index).getId(), id)) {
                continue;
            }
            indexes.add(index);
        }
        for (int i : indexes) {
            result.add(songsList.get(i));
        }
        return result;
    }

}
