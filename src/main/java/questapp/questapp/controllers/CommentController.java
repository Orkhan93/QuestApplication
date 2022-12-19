package questapp.questapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import questapp.questapp.entities.Comment;
import questapp.questapp.requests.CommentCreateRequest;
import questapp.questapp.services.CommentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return commentService.getAllComments(userId,postId);

    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentRequest){
        return commentService.createOneComment(commentRequest);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId){
        return commentService.getOneComment(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateCommentById(@PathVariable Long commentId , @RequestBody CommentCreateRequest createRequest){
        return commentService.updateOneComment(commentId , createRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId){
        commentService.deleteOneComment(commentId);
    }
}