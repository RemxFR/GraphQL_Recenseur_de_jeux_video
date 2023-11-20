package fr.graphsql.games.dto.repositories;

import fr.graphsql.games.entity.Game;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

    @Query("SELECT g FROM t_game g JOIN t_studio s WHERE s.id = ?1")
    List<Game> findAllByStudios(Integer id);

    @Query("SELECT g FROM t_game g JOIN t_editor e WHERE e.id = ?1")
    List<Game> findAllByEditors(Integer id);
}
