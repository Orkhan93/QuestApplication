package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import questapp.questapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
