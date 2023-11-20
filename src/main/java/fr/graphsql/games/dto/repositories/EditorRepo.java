package fr.graphsql.games.dto.repositories;

import fr.graphsql.games.entity.Editor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditorRepo extends JpaRepository<Editor, Integer> {
    @Query("SELECT e.id, e.nom FROM t_editor e JOIN t_game g WHERE g.id = ?1")
    List<Editor> findAllEditorsByGameId(Integer id);
}
