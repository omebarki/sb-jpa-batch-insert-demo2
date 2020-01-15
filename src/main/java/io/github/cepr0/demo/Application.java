package io.github.cepr0.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories(considerNestedRepositories = true)
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    @Autowired
    private SaveService saveService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    @Transactional
    public void onReady(ApplicationReadyEvent e) {
        create();
        //create();

    }

    private void create() {
        List<Model> list = new ArrayList<>(1000);
        for (int i = 0; i < 2; i++) {
            list.add(new Model(i));
        }
        saveService.saveAllOneByOne(list);
    }

}
