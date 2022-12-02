package questapp.questapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import questapp.questapp.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
