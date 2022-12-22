package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import questapp.questapp.entities.Like;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByUserAndPost(Optional<Long> userId, Optional<Long> postId);

    List<Like> findByUserId(Optional<Long> userId);

    List<Like> findByPostId(Optional<Long> postId);
}
