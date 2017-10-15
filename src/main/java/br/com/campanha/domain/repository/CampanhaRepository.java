package br.com.campanha.domain.repository;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    List<Campanha> findByTime(Time time);
}
