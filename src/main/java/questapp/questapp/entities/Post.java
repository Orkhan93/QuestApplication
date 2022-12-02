package questapp.questapp.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

    private long userId;
}
