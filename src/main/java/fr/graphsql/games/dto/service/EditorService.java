package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.EditorRepo;
import fr.graphsql.games.entity.Editor;
import fr.graphsql.games.entity.Editors;
import fr.graphsql.games.entity.mapper.EditorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    private EditorRepo editorRepo;
    private EditorMapper editorMapper;

    @Autowired
    public EditorService(EditorRepo editorRepo, EditorMapper editorMapper) {
        this.editorRepo = editorRepo;
        this.editorMapper = editorMapper;
    }

    public List<Editor> findByGame(Integer gameId) {
        List<Editor> editors = this.editorRepo.findAllByGames(gameId);
        return editors.isEmpty() ? null : editors;
    }

    public Editor findById(Integer editorId) {
        Optional<Editor> optionalEditor = this.editorRepo.findById(editorId);
        return optionalEditor.orElse(null);
    }

    public Editors findAll(Integer nbrPage) {
        int nbrPageNotNull = 10;
        if(nbrPage != null) {
            nbrPageNotNull = nbrPage;
        }
        Page<Editor> editorsPage = this.editorRepo.findAll(Pageable.ofSize(nbrPageNotNull));
        Editors editors = this.editorMapper.pageToEditorsMapping(editorsPage);
        return editors;
    }
}
