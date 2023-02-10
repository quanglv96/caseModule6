package ndtq.service.users;


import ndtq.model.Users;
import ndtq.service.IGeneralService;

import java.util.Optional;


public interface IUserService extends IGeneralService<Users> {
    void updatePasswordByID(String newPass, Long id);
    Iterable<Users> findAllByNameContaining(String name);
    void updateUser(Long id, String name, String address, String email, String phone);

    Optional<Users> findUserByName(String name);
    Optional<Users> findUserByUsername(String username);

    Boolean checkUsername(String name);

}
