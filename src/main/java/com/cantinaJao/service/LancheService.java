package com.cantinaJao.service;

import com.cantinaJao.model.Lanche;
import com.cantinaJao.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LancheService {
    @Autowired
    private LancheRepository lancheRepository;

    public List<Lanche> listarTodos(){
        return lancheRepository.findAll();
    }
}
