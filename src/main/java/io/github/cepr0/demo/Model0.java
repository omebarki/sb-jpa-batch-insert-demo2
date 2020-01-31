package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Model0 {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ligne_generator0")
    @SequenceGenerator(name = "ligne_generator0", sequenceName = "ISEQ$$_model2", allocationSize = 1000)
    private Long id;
    private Integer number;

    Model0(Integer number) {
        this.number = number;
    }


}