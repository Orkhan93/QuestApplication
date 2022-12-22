package questapp.questapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {

    private long id;
    private long userId;
    private long postId;
    private String text;
}
