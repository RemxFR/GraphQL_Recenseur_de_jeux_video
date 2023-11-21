package fr.graphsql.games.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Infos {
    private Integer count;
    private Integer pages;
    private Integer nextPage;
    private Integer previousPage;
}
