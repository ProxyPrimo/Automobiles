package automobiles.service;

import automobiles.model.entities.UserEntity;

public interface UserService {
    void initUsers();
    UserEntity findByEmail(String email);
}
