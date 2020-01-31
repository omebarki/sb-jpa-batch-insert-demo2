package io.github.cepr0.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.sql.DataSource;

@Component
@Order(-2147483629)
public class DataSourceHelper {
    public static DataSource DATA_SOURCE;

    public DataSourceHelper(@Autowired DataSource ds) {
        DATA_SOURCE = ds;
        System.out.println("11111111111111111111111111111111111111111111111111111111111111");
    }

}
