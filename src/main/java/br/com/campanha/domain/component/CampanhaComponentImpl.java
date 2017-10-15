package br.com.campanha.domain.component;

import br.com.campanha.domain.component.impl.CampanhaComponent;
import br.com.campanha.domain.model.Campanha;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.util.List;

@Component
public class CampanhaComponentImpl implements CampanhaComponent {

    @Override
    public List<Campanha> alteraDataVigencia (Campanha campanhaAtual, List<Campanha> campanhas) {
        campanhas.forEach(campanha -> {
            Period period = Period.between(campanhaAtual.getDataFimVigencia(), campanha.getDataFimVigencia());
            if (diferencaDeDiasIguais(period)) {
                campanha.setDataFimVigencia(campanha.getDataFimVigencia().plusDays(1));
            }
        });
        return campanhas;
    }

    @Override
    public void adicionarUmDiaNaDataFinal(List<Campanha> campanhas) {
        campanhas.forEach(c -> c.setDataFimVigencia(c.getDataFimVigencia().plusDays(1)));
    }

    private boolean diferencaDeDiasIguais(Period period) {
        return period.getDays() == 0;
    }
}
