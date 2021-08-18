package automobiles.service.impl;

import automobiles.model.entities.UserEntity;
import automobiles.repository.UserRepository;
import automobiles.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initUsers() {
        if (userRepository.count() == 0) {
            String adminNames = "Admin";
            String userNames = "User";
            String peterNames = "Peter";

            userRepository.saveAllAndFlush(List.of(
                    new UserEntity(24, "admin@admin.com", adminNames, adminNames, adminNames),
                    new UserEntity(30, "user@user.com", userNames, userNames, userNames),
                    new UserEntity(21, "peter@peter.com", peterNames, peterNames, peterNames)
            ));
        }
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
