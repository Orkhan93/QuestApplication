package questapp.questapp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questapp.questapp.entities.Post;
import questapp.questapp.entities.User;
import questapp.questapp.repositories.PostRepository;
import questapp.questapp.requests.PostCreateRequest;
import questapp.questapp.requests.PostUpdateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());

        return postRepository.findAll();
    }

    public Post getOnePost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {

        User user = userService.getOneUser(newPostRequest.getUserId());

        if (user == null)
            return null;

        Post toSave =new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);

        return postRepository.save(toSave);
    }


    public Post updateOnePost(Long postId,PostUpdateRequest updatePost) {

        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){

            Post toUpdate = post.get();
            toUpdate.setTitle(updatePost.getTitle());
            toUpdate.setText(updatePost.getText());
            postRepository.save(toUpdate);

            return toUpdate;
        }
        return null;

    }

    public void deleteOnePost(Long id) {
        postRepository.deleteById(id);
    }
}




