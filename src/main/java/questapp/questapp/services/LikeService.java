package questapp.questapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questapp.questapp.entities.Like;
import questapp.questapp.entities.Post;
import questapp.questapp.entities.User;
import questapp.questapp.repositories.LikeRepository;
import questapp.questapp.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {

        if (userId.isPresent() && postId.isPresent()){
            return likeRepository.findByUserAndPost(userId,postId);

        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId);

        } else if (postId.isPresent()) {
            return likeRepository.findByPostId(postId);

        }else
            return likeRepository.findAll();
    }

    public Like getLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createLikeById(Long likeId, LikeCreateRequest createLike) {

        User user = userService.getOneUser(createLike.getUserId());

        Post post = postService.getOnePost(createLike.getPostId());

        if (user != null && post != null){

            Like likeToSave = new Like();
            likeToSave.setText(likeToSave.getText());
            likeToSave.setUser(user);
            likeToSave.setPost(post);
            likeToSave.setId(likeToSave.getId());

            return likeRepository.save(likeToSave);
        }else
            return null;
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
