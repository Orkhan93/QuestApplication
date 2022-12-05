package questapp.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;



    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
