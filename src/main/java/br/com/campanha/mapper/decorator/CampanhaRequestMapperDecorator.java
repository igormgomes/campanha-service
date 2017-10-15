package br.com.campanha.mapper.decorator;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.mapper.request.CampanhaRequestMapper;
import br.com.campanha.request.CampanhaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CampanhaRequestMapperDecorator implements CampanhaRequestMapper {

    @Autowired @Qualifier("delegate")
    private CampanhaRequestMapper campanhaRequestMapper;

    @Autowired
    private TimeService timeService;

    @Override
    public Campanha parse(CampanhaRequest campanhaRequest) {
        Campanha campanha = this.campanhaRequestMapper.parse(campanhaRequest);

        Time time = this.timeService.buscaPorId(campanhaRequest.getIdTimeDoCoracao());
        campanha.setTime(time);

        return campanha;
    }
}
