package br.com.campanha.mapper.request;

import br.com.campanha.domain.builder.CampanhaBuilder;
import br.com.campanha.domain.model.Campanha;
import br.com.campanha.request.CampanhaUsuarioRequest;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CampanhaUsuarioRequestMapper {

    public List<Campanha> parse (CampanhaUsuarioRequest campanhaUsuarioRequest) {
        List<Campanha> campanhas = Lists.newArrayList();
        campanhaUsuarioRequest.getIdsCampanha().forEach(id -> {
            Campanha campanha = CampanhaBuilder.builder()
                    .id(id)
                    .idUsuario(campanhaUsuarioRequest.getIdUsuario())
                    .build();
            campanhas.add(campanha);
        });
        return campanhas;
    }
}