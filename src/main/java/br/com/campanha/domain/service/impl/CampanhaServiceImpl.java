package br.com.campanha.domain.service.impl;

import br.com.campanha.domain.component.CampanhaComponent;
import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.repository.CampanhaRepository;
import br.com.campanha.domain.repository.custom.CampanhaCustomRepository;
import br.com.campanha.domain.service.CampanhaService;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CampanhaServiceImpl implements CampanhaService {

    private CampanhaRepository campanhaRepository;
    private CampanhaComponent campanhaComponent;
    private CampanhaCustomRepository campanhaCustomRepository;
    private TimeService timeService;

    @Autowired
    public CampanhaServiceImpl(CampanhaRepository campanhaRepository, CampanhaComponent campanhaComponent,
                               CampanhaCustomRepository campanhaCustomRepository, TimeService timeService) {
        this.campanhaRepository = campanhaRepository;
        this.campanhaComponent = campanhaComponent;
        this.campanhaCustomRepository = campanhaCustomRepository;
        this.timeService = timeService;
    }

    @Override
    public Campanha salva(Campanha campanha) {

        List<Campanha> campanhas = this.campanhaCustomRepository.listaVigentes(campanha.getDataFimVigencia());
        if(!campanhas.isEmpty()) {
            this.campanhaComponent.adicionarUmDiaNaDataFinal(campanhas);
        }
        campanhas = this.campanhaComponent.alteraDataVigencia(campanha, campanhas);
        campanhas.add(campanha);

        this.campanhaRepository.save(campanhas);
        return campanha;
    }

    @Override
    public List<Campanha> busca() {
        List<Campanha> campanhas = this.campanhaCustomRepository.listaVigentes(LocalDate.now());
        campanhas.stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Nenhuma campanha cadastrada"));
        return campanhas;
    }

    @Override
    public void deleta(Long id) {
        Campanha campanha = buscaPorId(id);
        this.campanhaRepository.delete(campanha);
    }

    @Override
    public void edita(Campanha campanha, Long id) {
        buscaPorId(id);
        campanha.setId(id);
        this.campanhaRepository.save(campanha);
    }

    @Override
    public Campanha buscaPorId(Long id) {
        return Optional.ofNullable(this.campanhaRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException(String.format("%s %d %s", "Campanha de id", id, "não encontrada")));
    }

    @Override
    public void associa(List<Campanha> campanhas) {
        campanhas.forEach(c -> {
            Campanha campanha = buscaPorId(c.getId());
            if(!c.getIdUsuario().equals(campanha.getIdUsuario())) {
                campanha.setIdUsuario(c.getIdUsuario());
                this.campanhaRepository.save(campanha);
            }
        });
    }

    @Override
    public List<Campanha> buscaPorIdTime(Long id) {
        Time time = this.timeService.buscaPorId(id);
        List<Campanha> campanhas = this.campanhaCustomRepository.listaVigentes(LocalDate.now(), time);
        campanhas.stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("%s %d %s", "Campanha de id time", id, "não encontrada")));
        return campanhas;
    }
}