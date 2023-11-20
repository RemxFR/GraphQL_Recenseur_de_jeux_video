package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.StudioRepo;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    private StudioRepo studioRepo;

    @Autowired
    public StudioService(StudioRepo studioRepo) {
        this.studioRepo = studioRepo;
    }

    public List<Studio> findByGame(Integer gameId) {
        List<Studio> studios = this.studioRepo.findAllByGames(gameId);
        return studios.isEmpty() ? null : studios;
    }

    public Studio findById(Integer studioId) {
        Optional<Studio> studioOptional = this.studioRepo.findById(studioId);
        return studioOptional.orElse(null);
    }
}
