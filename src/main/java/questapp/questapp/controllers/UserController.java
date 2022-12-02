package questapp.questapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import questapp.questapp.entities.User;
import questapp.questapp.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User creatUser(@RequestBody User newUser){
        return userRepository.save(newUser);

    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception
        return userRepository.findById(userId).orElse(null);

    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId , @RequestBody User newUser){

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

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }


}
