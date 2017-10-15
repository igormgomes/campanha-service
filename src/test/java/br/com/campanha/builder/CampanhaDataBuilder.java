package br.com.campanha.builder;

import br.com.campanha.domain.model.Campanha;

import java.time.LocalDate;

public class CampanhaDataBuilder {

    private LocalDate dataInicioVigencia;
    private LocalDate dataFimVigencia;
    private String nome;

    public static CampanhaDataBuilder builder() {
        return new CampanhaDataBuilder();
    }

    public CampanhaDataBuilder dataInicioVigencia(LocalDate dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
        return this;
    }

    public CampanhaDataBuilder dataFimVigencia(LocalDate dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
        return this;
    }

    public CampanhaDataBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Campanha build() {
        return new Campanha(this.dataInicioVigencia, this.dataFimVigencia, this.nome);
    }
}
