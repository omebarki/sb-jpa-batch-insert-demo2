package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepo extends JpaRepository<Model, Long> {
    @Query(value = "select m from Model m where m.id =:id")
    public Model findOneById(@Param("id") Long id);

    @Query(value = "select m from Model m where m.id in :id")
    public Model findAllById(@Param("id") List<Long> id);


    public List<Model> selectAll();

}