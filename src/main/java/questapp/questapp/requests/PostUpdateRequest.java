package questapp.questapp.requests;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String title;
    private String text;
}
