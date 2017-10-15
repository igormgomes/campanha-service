package br.com.campanha.util;

import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.repository.TimeRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeRunner implements ApplicationRunner {

    private TimeRepository timeRepository;

    @Autowired
    public TimeRunner(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Time corinthians = new Time("Corinthians");
        Time palmeiras = new Time("Palmeiras");
        Time saoPaulo = new Time("São Paulo");
        Time santos = new Time("Santos");

        List<Time> times = Lists.newArrayList(corinthians, palmeiras, saoPaulo, santos);
        this.timeRepository.save(times);
    }
}
