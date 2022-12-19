package questapp.questapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import questapp.questapp.entities.Post;
import questapp.questapp.requests.PostCreateRequest;
import questapp.questapp.requests.PostUpdateRequest;
import questapp.questapp.services.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }


    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getOnePost(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePostById(@PathVariable Long postId , @RequestBody PostUpdateRequest updatePost){
        return postService.updateOnePost(postId,updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){
        postService.deleteOnePost(postId);
    }


}
