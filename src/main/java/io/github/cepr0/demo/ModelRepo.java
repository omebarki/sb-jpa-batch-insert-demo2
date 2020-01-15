package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ModelRepo extends JpaRepository<Model, Long> {
    @Query(value = "select m from Model m where m.id =:id")
    public Model  findOneById(@Param("id") Long id);

    @Query(value = "select m from Model m where m.id in :id")
    public Model  findAllById(@Param("id") List<Long> id);
    //@Query(value = "select * from dual", nativeQuery = true)
}