package fr.graphsql.games.dto.controller;

import fr.graphsql.games.dto.service.EditorService;
import fr.graphsql.games.dto.service.GameService;
import fr.graphsql.games.dto.service.StudioService;
import fr.graphsql.games.entity.Editor;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    private GameService gameService;
    private StudioService studioService;
    private EditorService editorService;

    @Autowired
    public GraphQLController(GameService gameService, StudioService studioService, EditorService editorService) {
        this.gameService = gameService;
        this.studioService = studioService;
        this.editorService = editorService;
    }

    @QueryMapping
    public Game gameById(@Argument String id) {
        return this.gameService.findById(Integer.getInteger(id));
    }

    @SchemaMapping(typeName = "Game", field = "studios")
    public List<Studio> studioList(Game game) {
        return this.studioService.findByGame(game);
    }

    @SchemaMapping(typeName = "Game", field = "editors")
    public List<Editor> editorList(Game game) {
        return this.editorService.findByGame(game);
    }

}
