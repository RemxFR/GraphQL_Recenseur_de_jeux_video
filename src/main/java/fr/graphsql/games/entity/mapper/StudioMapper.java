package fr.graphsql.games.entity.mapper;

import fr.graphsql.games.entity.Studio;
import fr.graphsql.games.entity.Studios;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudioMapper {

    @Mapping(source = "totalElements", target = "infos.count")
    @Mapping(source = "totalPages", target = "infos.pages")
    @Mapping(source = "pageable", target = "infos.nextPage", qualifiedByName = "getNextPage")
    @Mapping(source = "pageable", target = "infos.previousPage", qualifiedByName = "getPreviousPage")
    @Mapping(source = "content", target = "results")
    Studios pageToStudiosMapping(Page<Studio> studios);

    @Named("getNextPage")
    default Integer getNextPage(Pageable page) {
        return page.getPageNumber() + 1;
    }

    @Named("getPreviousPage")
    default Integer getPreviousPage(Pageable page) {
        return page.getPageNumber() - 1;
    }
}
