package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import questapp.questapp.entities.Like;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
