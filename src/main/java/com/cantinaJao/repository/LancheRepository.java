package com.cantinaJao.repository;

import com.cantinaJao.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Collectors;

public interface LancheRepository extends JpaRepository<Lanche, Long> {

}

