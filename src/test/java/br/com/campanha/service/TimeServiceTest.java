package br.com.campanha.service;

import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.repository.TimeRepository;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.domain.service.impl.TimeServiceImpl;
import br.com.campanha.exception.NotFoundException;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Teste do service da time")
public class TimeServiceTest {

    private TimeRepository timeRepository;
    private TimeService timeService;

    @BeforeEach
    public void beforeEach () {
        this.timeRepository = mock(TimeRepository.class);
        this.timeService = new TimeServiceImpl(this.timeRepository);
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso nao volte elementos na lista")
    public void testaQueEhLancadaUmaExceptionCasoNaoVolteElementosNaLista() {
        when(this.timeRepository.findAll())
                .thenReturn(Lists.newArrayList());

        assertThrows(NotFoundException.class, () -> this.timeService.busca());
    }

    @Test
    @DisplayName("Testa que a lista é retornada com elementos")
    public void testaQueAListaEhRetornadaComElementos() {
        when(this.timeRepository.findAll())
                .thenReturn(Lists.newArrayList(new Time("Barcelona")));

        assertTrue(this.timeService.busca().size() > 0);
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso o id para deleção seja inválido")
    public void testaQueEhLancadaUmaExceptionCasoOIdParaDelecaoSejaInvalido() {
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () ->  this.timeService.deleta(anyLong()));
    }

    @Test
    @DisplayName("Testa que a deleção é feita por um id valido")
    public void testaQueADelecaoEhFeitaPorUmIdValido() {
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(new Time("Barcelona"));

        this.timeService.deleta(anyLong());
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso o id para edição seja inválido")
    public void testaQueEhLancadaUmaExceptionCasoOIdParaEdicaoSejaInvalido() {
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () ->  this.timeService.edita(new Time(), anyLong()));
    }

    @Test
    @DisplayName("Testa que a edição é feita por um id válido")
    public void testaQueAEdicaoEhFeitaPorUmIdValido() {
        Time time = new Time("Real madrid");
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(time);

        this.timeService.edita(new Time(), anyLong());
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso a busca seja por um id invalido")
    public void testaQueEhLancadaUmaExceptionCasoABuscaSejaPorUmIdInvalido() {
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () ->  this.timeService.buscaPorId(anyLong()));
    }

    @Test
    @DisplayName("Testa que é retornado um time por um id válido")
    public void testaQueEhRetornadoUmTimePorUmIdValido() {
        when(this.timeRepository.findOne(anyLong()))
                .thenReturn(new Time("Barcelona"));

        assertEquals("Barcelona", this.timeService.buscaPorId(anyLong()).getNome());
    }
}
