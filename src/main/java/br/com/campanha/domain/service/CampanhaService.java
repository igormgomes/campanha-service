package br.com.campanha.domain.service;

import br.com.campanha.domain.model.Campanha;

import java.util.List;

public interface CampanhaService {

    Campanha salva (Campanha campanha);

    List<Campanha> busca();

    void deleta(Long id);

    void edita(Campanha campanha, Long id);

    Campanha buscaPorId(Long id);

    void associa(List<Campanha> campanhaTimeRequest);

    List<Campanha> buscaPorIdTime(Long id);
}
