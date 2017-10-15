package br.com.campanha.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Dados referente ao time")
public class TimeResponse {

    @ApiModelProperty(value = "Id", required = true, dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "Nome", required = true, dataType = "Long")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
