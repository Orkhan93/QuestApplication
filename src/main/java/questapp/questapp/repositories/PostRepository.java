package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import questapp.questapp.entities.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
