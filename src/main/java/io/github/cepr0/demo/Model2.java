package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Model2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model2_seq")
    @GenericGenerator(
            name = "model2_seq",
            strategy = "io.github.cepr0.demo.PooledSequenceIdGenerator",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "3")}
    )
    private Long id;
    private Integer numberr;

    Model2(Integer numberr) {
        this.numberr = numberr;
    }


}