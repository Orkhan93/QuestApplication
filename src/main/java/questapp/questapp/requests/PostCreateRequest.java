package questapp.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

    private long id;
    private String title;
    private String text;
    private long userId;
}
