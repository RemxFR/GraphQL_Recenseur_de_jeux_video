package fr.graphsql.games.dto.service;

import fr.graphsql.games.entity.Game;
import fr.graphsql.games.entity.Studio;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class GameSpecification {

    public static Specification<Game> gamePredication(String platform, String genre, String studio) {
            return (root, query, criteriaBuilder) -> {

                List<Predicate> predicates = new ArrayList<>();

                if(platform != null) {
                    predicates.add(criteriaBuilder.isMember(platform, root.get("platforms")));
                }
                if(genre != null) {
                    predicates.add(criteriaBuilder.isMember(genre, root.get("genres")));
                }
                if(studio != null) {
                    Join<Game, Studio> joinGS = root.join("studios", JoinType.INNER);
                    predicates.add(criteriaBuilder.equal(joinGS.get("name"), studio));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
    }
}
