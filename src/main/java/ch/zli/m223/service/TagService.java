package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Workspace;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Workspace createTag(Workspace workspace) {
        entityManager.persist(workspace);
        return workspace;
    }

    @Transactional
    public void deleteTag(Long id) {
        var entity = entityManager.find(Workspace.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Workspace updateTag(Long id, Workspace workspace) {
        return entityManager.merge(workspace);
    }

    public List<Workspace> findAll() {
        var query = entityManager.createQuery("FROM Tag", Workspace.class);
        return query.getResultList();
    }
}