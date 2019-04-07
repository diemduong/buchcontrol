package com.buchdemo.buchcontrol.repository;

import com.buchdemo.buchcontrol.model.Buch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public interface BuchRepository extends JpaRepository<Buch, Long> {

    List<Buch> findByTitel(String titel);
    List<Buch> findByAuthor(String author);
    Buch findById(long id);

}
