package com.github.volodyalombrozo.excel_65704046;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class MyDataSource {

    @Autowired
    private EntityManager manager;

    @Autowired
    private SpringRepository repo;

    public void initDB() {
        Animal elephant = new Animal(1, "elephant");
        Animal lion = new Animal(2, "lion");
        repo.save(elephant);
        repo.save(lion);
    }

    public List<Object[]> loadData() {
        return manager.createNativeQuery("select * from animals").getResultList();
    }

}
