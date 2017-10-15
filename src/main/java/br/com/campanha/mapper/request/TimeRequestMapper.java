package br.com.campanha.mapper.request;

import br.com.campanha.domain.model.Time;
import br.com.campanha.request.TimeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TimeRequestMapper {

    @Mappings(value = {
            @Mapping(source = "nome", target = "nome"),
    })
    Time parse(TimeRequest timeRequest);
}
