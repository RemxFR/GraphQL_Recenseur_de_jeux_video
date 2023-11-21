package fr.graphsql.games.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Studios {
    private Infos infos;
    private List<Studio> results;
}
