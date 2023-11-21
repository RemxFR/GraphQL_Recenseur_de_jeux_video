package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.GameRepo;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Games;
import fr.graphsql.games.entity.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepo gameRepo;
    private GameMapper gameMapper;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public GameService(GameRepo gameRepo, GameMapper gameMapper) {
        this.gameRepo = gameRepo;
        this.gameMapper = gameMapper;
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

    public Games findAllByArguments(Integer pages,
                                    String genre,
                                    String platform,
                                    String studio) {
        int nbrPage = 10;
        if (pages != null) {
            nbrPage = pages;
        }
        Page<Game> gamesPage = this.gameRepo.findAll(GameSpecification.gamePredication(platform, genre, studio), Pageable.ofSize(nbrPage));
        Games games = gameMapper.pageToGamesMapping(gamesPage);
        return games;
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
