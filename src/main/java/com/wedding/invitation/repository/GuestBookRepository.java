package com.wedding.invitation.repository;

import com.wedding.invitation.domain.GuestBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuestBookRepository {

    private final EntityManager em;

    public void save(GuestBook guestBook) {
        em.persist(guestBook);
    }

    public GuestBook findOne(Long id) {
        return em.find(GuestBook.class, id);
    }

    public List<GuestBook> findAll() {
        return em.createQuery("select g from GuestBook g", GuestBook.class)
                .getResultList();
    }

    public void delete(GuestBook guestBook) { em.remove(guestBook); }
}
