package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ligne_generator")
    @SequenceGenerator(name = "ligne_generator", sequenceName = "ligne_seq", allocationSize = 1000)

    private Long id;
    private Integer number;

    Model(Integer number) {
        this.number = number;
    }


}