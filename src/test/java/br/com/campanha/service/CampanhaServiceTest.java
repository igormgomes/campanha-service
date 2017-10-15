package br.com.campanha.service;

import br.com.campanha.domain.component.impl.CampanhaComponentImpl;
import br.com.campanha.domain.component.CampanhaComponent;
import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.repository.CampanhaRepository;
import br.com.campanha.domain.repository.custom.CampanhaCustomRepository;
import br.com.campanha.domain.service.CampanhaService;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.domain.service.impl.CampanhaServiceImpl;
import br.com.campanha.exception.NotFoundException;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Teste do service da campanha")
public class CampanhaServiceTest {

    private CampanhaRepository campanhaRepository;
    private CampanhaComponent campanhaComponent;
    private CampanhaCustomRepository campanhaCustomRepository;
    private TimeService timeService;
    private CampanhaService campanhaService;

    @BeforeEach
    public void beforeEach () {
        this.campanhaRepository = mock(CampanhaRepository.class);
        this.campanhaComponent = new CampanhaComponentImpl();
        this.campanhaCustomRepository = mock(CampanhaCustomRepository.class);
        this.timeService = mock(TimeService.class);
        this.campanhaService = new CampanhaServiceImpl(this.campanhaRepository,this.campanhaComponent,
                this.campanhaCustomRepository, this.timeService);
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso nao volte elementos na lista")
    public void testaQueEhLancadaUmaExceptionCasoNaoVolteElementosNaLista() {
        when(this.campanhaCustomRepository.listaVigentes(anyObject()))
                .thenReturn(Lists.newArrayList());

        assertThrows(NotFoundException.class, () -> this.campanhaService.busca());
    }

    @Test
    @DisplayName("Testa que a lista é retornada com elementos")
    public void testaQueAListaEhRetornadaComElementos() {
        when(this.campanhaCustomRepository.listaVigentes(anyObject()))
                .thenReturn(Lists.newArrayList(new Campanha()));

        assertTrue(!this.campanhaService.busca().isEmpty());
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso o id para deleção seja inválido")
    public void testaQueEhLancadaUmaExceptionCasoOIdParaDelecaoSejaInvalido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () ->  this.campanhaService.deleta(anyLong()));
    }

    @Test
    @DisplayName("Testa que a deleção é feita por um id valido")
    public void testaQueADelecaoEhFeitaPorUmIdValido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(new Campanha());

        this.campanhaService.deleta(anyLong());
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso o id para edição seja inválido")
    public void testaQueEhLancadaUmaExceptionCasoOIdParaEdicaoSejaInvalido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () ->  this.campanhaService.edita(new Campanha(), anyLong()));
    }

    @Test
    @DisplayName("Testa que a edição é feita por um id válido")
    public void testaQueAEdicaoEhFeitaPorUmIdValido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(new Campanha());

        this.campanhaService.edita(new Campanha(), anyLong());
    }

    @Test
    @DisplayName("Testa que é lançada uma exception caso a busca seja por um id invalido")
    public void testaQueEhLancadaUmaExceptionCasoABuscaSejaPorUmIdInvalido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(null);

        assertThrows(NotFoundException.class, () -> this.campanhaService.buscaPorId(anyLong()));
    }

    @Test
    @DisplayName("Testa que é retornado um time por um id válido")
    public void testaQueEhRetornadoUmTimePorUmIdValido() {
        when(this.campanhaRepository.findOne(anyLong()))
                .thenReturn(new Campanha("Campanha 1"));

        assertEquals("Campanha 1", this.campanhaService.buscaPorId(anyLong()).getNome());
    }
}