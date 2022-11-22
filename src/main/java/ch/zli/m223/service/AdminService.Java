package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Admin;

@ApplicationScoped
public class AdminService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Admin createAdmin(Admin admin) {
        entityManager.persist(admin);
        return admin;
    }

    @Transactional
    public void deleteAdmin(Long id) {
        var entity = entityManager.find(Admin.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Admin updateAdmin(Long id, Admin admin) {
        return entityManager.merge(admin);
    }

    public List<Admin> findAll() {
        var query = entityManager.createQuery("FROM Admin", Admin.class);
        return query.getResultList();
    }
}
