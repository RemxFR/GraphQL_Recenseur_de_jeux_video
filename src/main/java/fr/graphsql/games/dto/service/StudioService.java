package fr.graphsql.games.dto.service;

import fr.graphsql.games.dto.repositories.StudioRepo;
import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Studio;
import fr.graphsql.games.entity.Studios;
import fr.graphsql.games.entity.mapper.StudioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    private StudioRepo studioRepo;
    private StudioMapper studioMapper;

    @Autowired
    public StudioService(StudioRepo studioRepo, StudioMapper studioMapper) {
        this.studioRepo = studioRepo;
        this.studioMapper = studioMapper;
    }

    public List<Studio> findByGame(Integer gameId) {
        List<Studio> studios = this.studioRepo.findAllByGames(gameId);
        return studios.isEmpty() ? null : studios;
    }

    public Studio findById(Integer studioId) {
        Optional<Studio> studioOptional = this.studioRepo.findById(studioId);
        return studioOptional.orElse(null);
    }

    public Studios findAll(Integer nbrPage) {
        int nbrPagesNotNull = 10;
        if(nbrPage != null) {
            nbrPagesNotNull = nbrPage;

        }
        Page<Studio> studiosPage = this.studioRepo.findAll(Pageable.ofSize(nbrPagesNotNull));
        Studios studios = this.studioMapper.pageToStudiosMapping(studiosPage);
        return studios;
    }
}
