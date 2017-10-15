package br.com.campanha.domain.builder;


import br.com.campanha.domain.model.Campanha;

public class CampanhaBuilder {

    private Long id;
    private Long idUsuario;

    public static CampanhaBuilder builder () {
        return new CampanhaBuilder();
    }

    public CampanhaBuilder id(Long id){
        this.id = id;
        return this;
    }

    public CampanhaBuilder idUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public Campanha build () {
        Campanha campanha = new Campanha();
        campanha.setId(this.id);
        campanha.setIdUsuario(this.idUsuario);
        return campanha;
    }
}