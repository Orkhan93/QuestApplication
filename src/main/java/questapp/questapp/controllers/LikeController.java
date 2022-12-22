package questapp.questapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import questapp.questapp.entities.Like;
import questapp.questapp.requests.LikeCreateRequest;
import questapp.questapp.services.LikeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId , @RequestParam Optional<Long> postId){
       return likeService.getAllLikes(userId,postId);
    }

    @PostMapping
    public Like createOneLike(@PathVariable Long likeId , @RequestBody LikeCreateRequest createLike){
        return likeService.createLikeById(likeId,createLike);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteLikeById(likeId);
    }
}
