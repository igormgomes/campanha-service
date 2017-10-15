package br.com.campanha.domain.repository.custom.impl;

import br.com.campanha.domain.model.Campanha;
import br.com.campanha.domain.model.Time;
import br.com.campanha.domain.repository.custom.CampanhaCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CampanhaCustomRepositoryImpl implements CampanhaCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Campanha> listaVigentes(LocalDate date) {
        String sql = "select c from Campanha c " +
                "where c.dataFimVigencia >= :hoje order by c.dataFimVigencia";

        return this.entityManager.createQuery(sql, Campanha.class)
                .setParameter("hoje", date)
                .getResultList();
    }

    @Override
    public List<Campanha> listaVigentes(LocalDate date, Time time) {
        String sql = "select c from Campanha c " +
                "inner join c.time " +
                "where c.dataFimVigencia >= :hoje " +
                "and c.time = :time " +
                "order by c.dataFimVigencia";

        return this.entityManager.createQuery(sql, Campanha.class)
                .setParameter("hoje", date)
                .setParameter("time", time)
                .getResultList();
    }
}