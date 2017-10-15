package br.com.campanha.api.controller;

import br.com.campanha.api.TimeResource;
import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.mapper.request.TimeRequestMapper;
import br.com.campanha.mapper.response.TimeResponseMapper;
import br.com.campanha.request.TimeRequest;
import br.com.campanha.response.TimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("time")
public class TimeController implements TimeResource {

    private TimeRequestMapper timeRequestMapper;
    private TimeResponseMapper timeResponseMapper;
    private TimeService timeService;

    @Autowired
    public TimeController(TimeRequestMapper timeRequestMapper, TimeResponseMapper timeResponseMapper, TimeService timeService) {
        this.timeRequestMapper = timeRequestMapper;
        this.timeResponseMapper = timeResponseMapper;
        this.timeService = timeService;
    }

    @Override
    public ResponseEntity salva(@RequestBody @Valid TimeRequest timeRequest) {
        Time time = this.timeRequestMapper.parse(timeRequest);
        this.timeService.salva(time);
        return ResponseEntity.created(URI.create("time/" + time.getId())).build();
    }

    @Override
    public ResponseEntity busca() {
        List<TimeResponse> times = this.timeResponseMapper.parse(this.timeService.busca());
        return ResponseEntity.ok(times);
    }

    @Override
    public ResponseEntity buscaPorId(@PathVariable("id") Long id) {
        TimeResponse time = this.timeResponseMapper.parse(this.timeService.buscaPorId(id));
        return ResponseEntity.ok(time);
    }

    @Override
    public ResponseEntity deleta(@PathVariable("id") Long id) {
        this.timeService.deleta(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity edita(@RequestBody @Valid TimeRequest timeRequest, @PathVariable("id") Long id) {
        this.timeService.edita(this.timeRequestMapper.parse(timeRequest), id);
        return ResponseEntity.ok().build();
    }
}
