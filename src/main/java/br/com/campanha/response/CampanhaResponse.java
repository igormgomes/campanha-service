package br.com.campanha.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "Dados referente a campanha")
public class CampanhaResponse {

    @ApiModelProperty(value = "Id da campanha", required = true, dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "Id do time do coração", required = true, dataType = "Long")
    private Long idTimeDoCoracao;

    @ApiModelProperty(value = "Data de inicio campanha", required = true, dataType = "Date", example = "12/12/2017")
    private LocalDate dataInicioVigencia;

    @ApiModelProperty(value = "Data de fim da campanha", required = true, dataType = "Date", example = "13/12/2017")
    private LocalDate dataFimVigencia;

    @ApiModelProperty(value = "Nome da campanha", required = true)
    private String nome;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIdTimeDoCoracao(Long idTimeDoCoracao) {
        this.idTimeDoCoracao = idTimeDoCoracao;
    }

    public Long getIdTimeDoCoracao() {
        return idTimeDoCoracao;
    }

    public LocalDate getDataInicioVigencia() {
        return dataInicioVigencia;
    }

    public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
        this.dataInicioVigencia = dataInicioVigencia;
    }

    public LocalDate getDataFimVigencia() {
        return dataFimVigencia;
    }

    public void setDataFimVigencia(LocalDate dataFimVigencia) {
        this.dataFimVigencia = dataFimVigencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
