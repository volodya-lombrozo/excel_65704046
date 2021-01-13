package com.github.volodyalombrozo.excel_65704046;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "animals")
@Entity
public class Animal {
    @Id
    private long id;
    private String name;

    public Animal() {
    }

    public Animal(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
