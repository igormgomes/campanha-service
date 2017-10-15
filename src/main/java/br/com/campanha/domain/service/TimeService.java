package br.com.campanha.domain.service;

import br.com.campanha.domain.model.Time;

import java.util.List;

public interface TimeService {

    Time salva (Time time);

    List<Time> busca();

    void deleta(Long id);

    void edita(Time campanha, Long id);

    Time buscaPorId(Long id);
}
