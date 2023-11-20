package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.StudioRepo;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    private StudioRepo studioRepo;

    @Autowired
    public StudioService(StudioRepo studioRepo) {
        this.studioRepo = studioRepo;
    }

    public List<Studio> findByGame(Game game) {
        List<Studio> studios = this.studioRepo.findAllByGameId(game.getId());
        return studios.isEmpty() ? null : studios;
    }
}
