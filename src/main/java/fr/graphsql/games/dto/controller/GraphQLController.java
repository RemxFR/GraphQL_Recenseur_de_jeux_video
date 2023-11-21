package fr.graphsql.games.dto.controller;

import fr.graphsql.games.dto.service.EditorService;
import fr.graphsql.games.dto.service.GameService;
import fr.graphsql.games.dto.service.StudioService;
import fr.graphsql.games.entity.Editor;
import fr.graphsql.games.entity.Editors;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Games;
import fr.graphsql.games.entity.Studio;
import fr.graphsql.games.entity.Studios;
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

    //Trouver un jeu par id
    @QueryMapping
    public Game game(@Argument String id) {
        return this.gameService.findById(Integer.parseInt(id));
    }

    @SchemaMapping
    public List<Studio> studioList(Game game) {
        return this.studioService.findByGame(game.getId());
    }

    @SchemaMapping
    public List<Editor> editorList(Game game) {
        return this.editorService.findByGame(game.getId());
    }

    //Trouver une liste de jeux
    @QueryMapping
    public Games games(
            @Argument Integer pages,
            @Argument String genre,
            @Argument String platform,
            @Argument String studio) {
        return this.gameService.findAllByArguments(pages, genre, platform, studio);
    }

    //Trouver un studio par id
    @QueryMapping
    public Studio studio(@Argument String id) {
        return this.studioService.findById(Integer.parseInt(id));
    }

    @SchemaMapping
    public List<Game> studioGamesList(Studio studio) {
        return this.gameService.findByStudio(studio.getId());
    }

    //Trouver liste des studios
    @QueryMapping
    public Studios studios(@Argument Integer nbrPage) {
        return this.studioService.findAll(nbrPage);
    }

    //Trouver un éditeur par id
    @QueryMapping
    public Editor editor(@Argument String id) {
        return this.editorService.findById(Integer.parseInt(id));
    }

    @SchemaMapping
    public List<Game> editorGamesList(Editor editor) {
        return this.gameService.findByEditor(editor.getId());
    }

    //Trouver tous les éditeurs
    @QueryMapping
    public Editors editors(@Argument Integer nbrPage) {
        return this.editorService.findAll(nbrPage);
    }

}
