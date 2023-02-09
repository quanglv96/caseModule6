package ndtq.service.users;

import CaseStudy4.model.Users;
import CaseStudy4.service.IGeneralService;

import java.util.Optional;


public interface IUserService extends IGeneralService<Users> {
    void updatePasswordByID(String newPass, Long id);
    Iterable<Users> findAllByNameContaining(String name);


    Optional<Users> findUserByName(String name);
    Optional<Users> findUserByUsername(String username);

    Boolean checkUsername(String name);

}
