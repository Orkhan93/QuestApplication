package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import questapp.questapp.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUserId(Long userId);
}
