package questapp.questapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questapp.questapp.entities.Comment;
import questapp.questapp.entities.Post;
import questapp.questapp.entities.User;
import questapp.questapp.repositories.CommentRepository;
import questapp.questapp.requests.CommentCreateRequest;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserAndPost(userId,postId);

        }else if(userId.isPresent()){
            return commentRepository.findByUserId(userId);

        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId);

        }else
            return commentRepository.findAll();
    }

    public Comment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }


    public Comment createOneComment(CommentCreateRequest commentRequest) {

        User user = userService.getOneUser(commentRequest.getUserId());

        Post post = postService.getOnePost(commentRequest.getPostId());

        if(user != null && post != null){

           Comment commentToSave = new Comment();
           commentToSave.setId(commentToSave.getId());
           commentToSave.setText(commentToSave.getText());
           commentToSave.setPost(post);
           commentToSave.setUser(user);
           return commentRepository.save(commentToSave);
        }else
            return null;
    }

    public Comment updateOneComment(Long commentId, CommentCreateRequest createRequest) {

        Optional<Comment> comment = commentRepository.findById(commentId);

        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(createRequest.getText());

            return  commentRepository.save(commentToUpdate);
        }else
            return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
