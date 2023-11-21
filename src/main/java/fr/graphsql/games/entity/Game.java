package fr.graphsql.games.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String name;

    @ElementCollection
    @CollectionTable(name = "t_genre", joinColumns = @JoinColumn(referencedColumnName = "nom"))
    @Column(name = "genres_liste")
    private List<String> genres;

    @Column(name = "date_de_publication")
    private long publicationDate;

    private Date dateTypePublicationDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "t_editor_games",
        joinColumns = @JoinColumn(referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private List<Editor> editors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "t_studio_games",
        joinColumns = @JoinColumn(referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private List<Studio> studios;

    @ElementCollection
    @CollectionTable(name = "t_platforms", joinColumns = @JoinColumn(referencedColumnName = "nom"))
    @Column(name = "plateformes_liste")
    private List<String> platforms;

}
