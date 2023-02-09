package ndtq.repository;


import ndtq.model.mp3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMp3Repository extends JpaRepository<mp3,Long> {
    int countByName(String name);
}
