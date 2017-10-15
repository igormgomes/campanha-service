package br.com.campanha.component;

import br.com.campanha.builder.CampanhaDataBuilder;
import br.com.campanha.domain.component.impl.CampanhaComponentImpl;
import br.com.campanha.domain.model.Campanha;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Teste do componente da campanha")
public class CampanhaComponentTest {

    private CampanhaComponentImpl campanhaComponentImpl;

    @BeforeEach
    public void beforeEach () {
        this.campanhaComponentImpl = new CampanhaComponentImpl();
    }

    @Test
    @DisplayName("Testa que é adiocnado um dia na data de fim de cada campanha")
    public void testaQueADataDeFimDeTodasAsCampanhasSaoDiferentes () {
        Campanha campanha1 = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 3))
                .nome("Campanha 1")
                .build();

        Campanha campanha2 = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 2))
                .nome("Campanha 2")
                .build();

        Campanha campanhaAtual = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 3))
                .nome("Campanha 3")
                .build();

        List<Campanha> campanhas = Lists.newArrayList(campanha2, campanha1);
        campanhas.sort(Comparator.comparing(Campanha::getDataFimVigencia));

        this.campanhaComponentImpl.alteraDataVigencia(campanhaAtual, campanhas);
        assertNotEquals(campanha1.getDataFimVigencia(), campanha2.getDataFimVigencia());
        assertNotEquals(campanha1.getDataFimVigencia(), campanhaAtual.getDataFimVigencia());

        assertNotEquals(campanha2.getDataFimVigencia(), campanha1.getDataFimVigencia());
        assertNotEquals(campanha2.getDataFimVigencia(), campanhaAtual.getDataFimVigencia());
    }

    @Test
    @DisplayName("Testa que é adiocnado um dia na data de fim de cada campanha")
    public void testaQueEhAdicionadoUmDiaNaDataFimDeCadaCampanha () {
        Campanha campanha1 = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 3))
                .nome("Campanha 1")
                .build();

        Campanha campanha2 = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 2))
                .nome("Campanha 2")
                .build();

        Campanha campanha3 = CampanhaDataBuilder.builder()
                .dataInicioVigencia(LocalDate.of(2017, Month.NOVEMBER, 1))
                .dataFimVigencia(LocalDate.of(2017, Month.NOVEMBER, 3))
                .nome("Campanha 3")
                .build();

        List<Campanha> campanhas = Lists.newArrayList(campanha1, campanha2, campanha3);
        this.campanhaComponentImpl.adicionarUmDiaNaDataFinal(campanhas);

        assertEquals(LocalDate.of(2017, Month.NOVEMBER, 4), campanha1.getDataFimVigencia());
        assertEquals(LocalDate.of(2017, Month.NOVEMBER, 3), campanha2.getDataFimVigencia());
        assertEquals(LocalDate.of(2017, Month.NOVEMBER, 4), campanha3.getDataFimVigencia());
    }
}