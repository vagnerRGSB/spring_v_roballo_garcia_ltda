package com.vagner.v_roballo_garcia_ltda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vagner.v_roballo_garcia_ltda.entity.NiveisAcessosEntity;

@Repository
public interface NiveisAcessosRepository extends JpaRepository<NiveisAcessosEntity, Integer> {
    
}
