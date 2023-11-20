package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.EditorRepo;
import fr.graphsql.games.entity.Editor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    private EditorRepo editorRepo;

    @Autowired
    public EditorService(EditorRepo editorRepo) {
        this.editorRepo = editorRepo;
    }

    public List<Editor> findByGame(Integer gameId) {
        List<Editor> editors = this.editorRepo.findAllByGames(gameId);
        return editors.isEmpty() ? null : editors;
    }

    public Editor findById(Integer editorId) {
        Optional<Editor> optionalEditor = this.editorRepo.findById(editorId);
        return optionalEditor.orElse(null);
    }
}
