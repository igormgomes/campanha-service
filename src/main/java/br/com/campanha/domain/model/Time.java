package br.com.campanha.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "time")
public class Time {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Time () {}

    public Time(String nome) {
        this.nome = nome;
    }

    public Time(Long id) {
        this.id = id;
    }

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
