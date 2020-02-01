package io.github.cepr0.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
https://thoughts-on-java.org/spring-data-jpa-named-queries/
*/
@Entity
@NoArgsConstructor
@Data
@NamedNativeQuery(name = "Model.selectAll",
        query = "select * from model",
        resultSetMapping = "Model.selectAll"
)
@SqlResultSetMapping(name = "Model.selectAll",
        entities = {
                @EntityResult(entityClass = Model.class, fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "number", column = "number")
                })}
)
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ligne_generator")
    @SequenceGenerator(name = "ligne_generator", sequenceName = "ligne_seq", allocationSize = 1000)
    private Long id;
    private Integer numberr;

    Model(Integer number) {
        this.numberr = number;
    }


}