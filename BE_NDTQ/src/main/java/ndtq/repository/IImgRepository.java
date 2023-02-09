package ndtq.repository;


import ndtq.model.images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImgRepository extends JpaRepository<images,Long> {
    int countByName(String name);
}
