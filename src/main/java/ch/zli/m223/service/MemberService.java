package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Member;

@ApplicationScoped
public class MemberService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Member createMember(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Transactional
    public void deleteMember(Long id) {
        var entity = entityManager.find(Member.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Member updatMember(Long id, Member member) {
        return entityManager.merge(member);
    }

    public List<Member> findAll() {
        var query = entityManager.createQuery("FROM Member", Member.class);
        return query.getResultList();
    }
}