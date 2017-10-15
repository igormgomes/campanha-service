package br.com.campanha.domain.repository.custom;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.model.Time;

import java.time.LocalDate;
import java.util.List;

public interface CampanhaCustomRepository {

    List<Campanha> listaVigentes (LocalDate date);

    List<Campanha> listaVigentes(LocalDate date, Time time);
}
