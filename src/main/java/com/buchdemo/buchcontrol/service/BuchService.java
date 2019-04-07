package com.buchdemo.buchcontrol.service;

import com.buchdemo.buchcontrol.model.Buch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuchService {

    public List<Buch> findByTitel(String titel);
    public List<Buch> findByAuthor(String author);
    public Buch findById(long id);
    public List<Buch> findAll();
    public Page<Buch> findAllBuch(PageRequest page);
    public Buch saveBuch (Buch buch);
    public Buch updateBuch (long id, Buch buch);
    public void deleteBuchById (long id);
    public void deleteAll ();

}
