package br.com.campanha.api.controller;

import br.com.campanha.api.CampanhaResource;
import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.service.CampanhaService;
import br.com.campanha.mapper.request.CampanhaRequestMapper;
import br.com.campanha.mapper.request.CampanhaUsuarioRequestMapper;
import br.com.campanha.mapper.response.CampanhaResponseMapper;
import br.com.campanha.request.CampanhaRequest;
import br.com.campanha.request.CampanhaUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("campanha")
public class CampanhaController implements CampanhaResource {

    private CampanhaRequestMapper campanhaRequestMapper;
    private CampanhaResponseMapper campanhaResponseMapper;
    private CampanhaUsuarioRequestMapper campanhaUsuarioRequestMapper;
    private CampanhaService campanhaService;

    @Autowired
    public CampanhaController(CampanhaRequestMapper campanhaRequestMapper, CampanhaResponseMapper campanhaResponseMapper,
                              CampanhaUsuarioRequestMapper campanhaUsuarioRequestMapper, CampanhaService campanhaService) {
        this.campanhaRequestMapper = campanhaRequestMapper;
        this.campanhaResponseMapper = campanhaResponseMapper;
        this.campanhaUsuarioRequestMapper = campanhaUsuarioRequestMapper;
        this.campanhaService = campanhaService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity salva(@RequestBody @Valid CampanhaRequest campanhaRequest) {
        Campanha campanha = this.campanhaService.salva(this.campanhaRequestMapper.parse(campanhaRequest));
        return ResponseEntity.created(URI.create("campanha/" + campanha.getId())).build();
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity busca() {
        List<Campanha> campanhas = this.campanhaService.busca();
        return ResponseEntity.ok(this.campanhaResponseMapper.parse(campanhas));
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity buscaPorId(@PathVariable("id") Long id) {
        Campanha campanha = this.campanhaService.buscaPorId(id);
        return ResponseEntity.ok(this.campanhaResponseMapper.parse(campanha));
    }

    @Override
    @GetMapping(value = "/time/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity buscaPorIdTime(@PathVariable("id") Long id) {
        List<Campanha> campanhas = this.campanhaService.buscaPorIdTime(id);
        return ResponseEntity.ok(this.campanhaResponseMapper.parse(campanhas));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleta(@PathVariable("id") Long id) {
        this.campanhaService.deleta(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    @PutMapping(value = "/{id}")
    public ResponseEntity edita(@RequestBody @Valid CampanhaRequest campanhaRequest, @PathVariable("id") Long id) {
        this.campanhaService.edita(this.campanhaRequestMapper.parse(campanhaRequest), id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping(value = "/associa")
    public ResponseEntity associa(@RequestBody @Valid CampanhaUsuarioRequest campanhaUsuarioRequest) {
        this.campanhaService.associa(this.campanhaUsuarioRequestMapper.parse(campanhaUsuarioRequest));
        return ResponseEntity.accepted().build();
    }
}
