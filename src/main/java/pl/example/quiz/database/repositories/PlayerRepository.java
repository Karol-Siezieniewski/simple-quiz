package pl.example.quiz.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.example.quiz.database.entities.PlayerEntity;


public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
