package com.codegym.repository;

import com.codegym.model.CityBoy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CityBoyRepositoryImpl implements CityBoyRepository<CityBoy> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CityBoy> findAll() {
        TypedQuery<CityBoy> query = entityManager.createQuery("select c from CityBoy c", CityBoy.class);
        return query.getResultList();
    }

    @Override
    public void save(CityBoy cityBoy) {
        if (cityBoy.getId() != null) {
            entityManager.merge(cityBoy);
        } else {
            entityManager.persist(cityBoy);
        }
    }

    @Override
    public void delete(Long id) {
        CityBoy cityBoy = findById(id);
        if(cityBoy != null) {
            entityManager.remove(cityBoy);
        }
    }

    @Override
    public CityBoy findById(Long id) {
        TypedQuery<CityBoy> query = entityManager.createQuery("select c from CityBoy c where c.id=:id", CityBoy.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
