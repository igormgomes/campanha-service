package br.com.campanha.request;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel(value = "Dados referente ao time")
public class TimeRequest {

    @NotBlank(message = "Nome deve estar preechido")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
