package br.com.campanha.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ApiModel(value = "Dados referente a campanha")
public class CampanhaRequest {

    @NotNull(message = "Data de início deve estar preechida")
    @ApiModelProperty(value = "Data de inicio campanha", required = true, dataType = "Date", example = "12/12/2017")
    private LocalDate dataInicioVigencia;

    @NotNull(message = "Data de fim deve estar preechida")
    @ApiModelProperty(value = "Data de fim da campanha", required = true, dataType = "Date", example = "13/12/2017")
    private LocalDate dataFimVigencia;

    @NotBlank(message = "Nome deve estar preechido")
    @ApiModelProperty(value = "Nome da campanha", required = true)
    private String nome;

    @NotNull(message = "Nome deve estar preechido")
    @ApiModelProperty(value = "Id do time do coração", required = true)
    private Long idTimeDoCoracao;

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

    public void setIdTimeDoCoracao(Long idTimeDoCoracao) {
        this.idTimeDoCoracao = idTimeDoCoracao;
    }

    public Long getIdTimeDoCoracao() {
        return idTimeDoCoracao;
    }
}
