package br.com.campanha.domain.service.impl;

import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.repository.TimeRepository;
import br.com.campanha.domain.service.TimeService;
import br.com.campanha.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    private TimeRepository timeRepository;

    @Autowired
    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Time salva(Time time) {
        return this.timeRepository.save(time);
    }

    @Override
    public List<Time> busca() {
        List<Time> times = this.timeRepository.findAll();
        times.stream()
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Nenhum time cadastrado"));
        return times;
    }

    @Override
    public void deleta(Long id) {
        Time time = buscaPorId(id);
        this.timeRepository.delete(time);
    }

    @Override
    public void edita(Time time, Long id) {
        buscaPorId(id);
        time.setId(id);
        this.timeRepository.save(time);
    }

    @Override
    public Time buscaPorId(Long id) {
        return Optional.ofNullable(this.timeRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException(String.format("%s %d %s", "Time de id", id, "não encontrado")));
    }
}
