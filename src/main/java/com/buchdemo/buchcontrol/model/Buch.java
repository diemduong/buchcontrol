package com.buchdemo.buchcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
@Table(name = "APP_BUCH")
public class Buch implements Serializable {

    @Id
    @Column(name="ID", nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="TITEL", nullable=false)
    private String titel;

    @Column(name="TYP")
    private String typ = Buchtyp.UNKATEGORISIERT.toString();

    @Column(name="AUTHOR")
    private String author;

    public Buch() {
        super();
    }

    public Buch(String titel, String typ, String author) {
        this.titel = titel;
        this.typ = typ;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
