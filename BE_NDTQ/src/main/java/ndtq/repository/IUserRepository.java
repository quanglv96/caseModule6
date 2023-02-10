package ndtq.repository;

import ndtq.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<Users, Long> {
    @Modifying
    @Query(value = "UPDATE `casestudy4`.`users` SET `password` = ?1 WHERE (`id` = ?2);", nativeQuery = true)
    void updatePasswordByID(String newPass, Long id);
    @Modifying
    @Query(value = "update users set  name = :name, address = :address, email = :email, phone = :phone where id = :id", nativeQuery = true)
    void updateUser(Long id,String name, String address, String email, String phone);
    Iterable<Users> findAllByNameContaining(String name);

    Optional<Users> findUserByName(String name);

    Optional<Users> findUserByUsername(String username);

    int countUsersByUsername(String name);


}
