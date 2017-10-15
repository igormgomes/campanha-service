package br.com.campanha.mapper.response;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.response.CampanhaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampanhaResponseMapper {

    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "time.id", target = "idTimeDoCoracao"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "dataInicioVigencia", target = "dataInicioVigencia"),
            @Mapping(source = "dataFimVigencia", target = "dataFimVigencia")
    })
    CampanhaResponse parse(Campanha campanha);

    List<CampanhaResponse> parse (List<Campanha> campanhas);

}
