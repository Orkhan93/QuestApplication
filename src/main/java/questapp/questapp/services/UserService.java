package questapp.questapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import questapp.questapp.entities.User;
import questapp.questapp.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){

            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);

            return foundUser;
        }else
            return null;
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
