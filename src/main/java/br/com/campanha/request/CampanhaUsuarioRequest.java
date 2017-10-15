package br.com.campanha.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "Dados referente a campanha usuário")
public class CampanhaUsuarioRequest {

    @NotNull(message = "Id's das campanhas devem estar preenchido")
    @ApiModelProperty(value = "Id's das campanhas", required = true, dataType = "Long")
    private List<Long> idsCampanha;

    @NotNull(message = "Id do usuário deve estar preenhido")
    @ApiModelProperty(value = "Id do usuário", required = true, dataType = "Long")
    private Long idUsuario;

    public List<Long> getIdsCampanha() {
        return idsCampanha;
    }

    public void setIdsCampanha(List<Long> idsCampanha) {
        this.idsCampanha = idsCampanha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
