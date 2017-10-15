package br.com.campanha.mapper.request;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.mapper.decorator.CampanhaRequestMapperDecorator;
import br.com.campanha.request.CampanhaRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
@DecoratedWith(CampanhaRequestMapperDecorator.class)
public interface CampanhaRequestMapper {

    @Mappings(value = {
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "dataInicioVigencia", target = "dataInicioVigencia"),
            @Mapping(source = "dataFimVigencia", target = "dataFimVigencia")
    })
    Campanha parse(CampanhaRequest campanhaRequest);
}
