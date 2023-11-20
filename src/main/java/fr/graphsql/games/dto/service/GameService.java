package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.GameRepo;
import fr.graphsql.games.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    private GameRepo gameRepo;

    @Autowired
    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Game findById(Integer id) {
        Optional<Game> optionalGame = this.gameRepo.findById(id);
        return optionalGame.isPresent() ? optionalGame.get() : null;
    }

    public Game addGame(Game game) {
        return this.gameRepo.save(game);
    }
}
