package fr.graphsql.games.dto.repositories;

import fr.graphsql.games.entity.Studio;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepo extends JpaRepository<Studio, Integer> {

    @Query("SELECT s.id, s.nom FROM t_studio s JOIN t_game g WHERE g.id = ?1")
    List<Studio> findAllByGameId(Integer id);
}
