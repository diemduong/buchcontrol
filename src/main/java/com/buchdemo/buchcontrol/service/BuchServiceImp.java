package com.buchdemo.buchcontrol.service;

import com.buchdemo.buchcontrol.model.Buch;
import com.buchdemo.buchcontrol.repository.BuchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuchServiceImp implements BuchService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BuchRepository buchRepository;

    @Override
    public List<Buch> findByTitel(String titel) {
        return buchRepository.findByTitel(titel);
    }

    @Override
    public Buch updateBuch(long id, Buch buch) {
        Buch found = buchRepository.findById(id);
        found.setTitel(buch.getTitel());
        found.setTyp(buch.getTyp());
        found.setAuthor(buch.getAuthor());
        return found;
    }
    @Override
    public List<Buch> findByAuthor(String author) {
        return buchRepository.findByAuthor(author);
    }

    @Override
    public Buch findById(long id) {
        return buchRepository.findById(id);
    }

    @Override
    public List<Buch> findAll() {
        return buchRepository.findAll();
    }

    @Override
    public Page<Buch> findAllBuch(PageRequest page) {return buchRepository.findAll(page);}
    @Override
    public Buch saveBuch(Buch buch) {
        return buchRepository.save(buch);
    }

    @Override
    public void deleteBuchById(long id) {
        buchRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        buchRepository.deleteAll();
    }
}
