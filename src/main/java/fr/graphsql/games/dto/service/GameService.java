package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.GameRepo;
import fr.graphsql.games.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
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
        return optionalGame.orElse(null);
    }

    public Game addGame(Game game) {
        Timestamp timestamp = Timestamp.from(game.getDateTypePublicationDate().toInstant());
        long timestampInt = timestamp.getTime();
        game.setPublicationDate(timestampInt);
        return this.gameRepo.save(game);
    }

    public List<Game> findAll() {
        return this.gameRepo.findAll();
    }

    public List<Game> findByStudio(Integer id) {
        List<Game> gameList = this.gameRepo.findAllByStudios(id);
        return gameList.isEmpty() ? null : gameList;
    }

    public List<Game> findByEditor(Integer id) {
        List<Game> gameList = this.gameRepo.findAllByEditors(id);
        return gameList.isEmpty() ? null : gameList;
    }
}
