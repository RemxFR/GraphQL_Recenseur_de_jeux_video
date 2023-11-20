package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.EditorRepo;
import fr.graphsql.games.entity.Editor;
import fr.graphsql.games.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorService {

    private EditorRepo editorRepo;

    @Autowired
    public EditorService(EditorRepo editorRepo) {
        this.editorRepo = editorRepo;
    }

    public List<Editor> findByGame(Game game) {
        List<Editor> editors = this.editorRepo.findAllEditorsByGameId(game.getId());
        return editors.isEmpty() ? null : editors;
    }
}
