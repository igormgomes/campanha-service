package br.com.campanha.domain.component;

import br.com.campanha.domain.model.Campanha;

import java.util.List;

public interface CampanhaComponent {

    List<Campanha> alteraDataVigencia (Campanha campanhaAtual, List<Campanha> campanhas);

    void adicionarUmDiaNaDataFinal(List<Campanha> campanhas);
}
