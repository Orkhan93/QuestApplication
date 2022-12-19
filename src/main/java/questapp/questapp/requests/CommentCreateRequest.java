package questapp.questapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {

    private long id;
    private long userId;
    private long postId;
    private String text;
}
