package jpabook.jpashop_v2.repository;

import jpabook.jpashop_v2.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository
{
    @PersistenceContext
    private EntityManager em;

    public Long save(Member m)
    {
        em.persist(m);
        return m.getId();
    }

    public Member findMember(Long id)
    {
        return em.find(Member.class,id);
    }
}
