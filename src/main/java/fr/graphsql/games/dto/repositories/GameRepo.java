package fr.graphsql.games.dto.repositories;

import fr.graphsql.games.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {
}
