package com.github.volodyalombrozo.excel_65704046;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepository extends JpaRepository<Animal, Long> {

}
