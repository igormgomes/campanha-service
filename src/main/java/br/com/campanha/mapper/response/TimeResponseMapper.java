package br.com.campanha.mapper.response;

import br.com.campanha.domain.model.Time;
import br.com.campanha.response.TimeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeResponseMapper {

    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nome", target = "nome"),
    })
    TimeResponse parse(Time time);

    List<TimeResponse> parse(List<Time> times);
}
