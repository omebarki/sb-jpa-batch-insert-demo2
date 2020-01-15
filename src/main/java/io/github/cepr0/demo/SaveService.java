package io.github.cepr0.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaveService {

    @Autowired
    ModelRepo modelRepo;
    @Autowired
    Model2Repo model2Repo;

    @Transactional
    public void saveAll(List<Model> list) {
        modelRepo.saveAll(list);
    }

    public void saveAllOneByOne(List<Model> list) {
        for (Model model : list) {
            modelRepo.save(model);
            model2Repo.save(new Model2(1));
        }
    }

    @Transactional
    Model findOne(Long id) {
        return modelRepo.findOneById(id);
    }

    @Transactional
    Model findAll(List<Long> ids) {
        return modelRepo.findAllById(ids);
    }

}
