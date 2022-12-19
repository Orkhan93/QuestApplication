package questapp.questapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import questapp.questapp.entities.User;
import questapp.questapp.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User creatUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);

    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
       return userService.getOneUser(userId);

    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId , @RequestBody User newUser){

       return userService.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteOneUser(userId);
    }


}
