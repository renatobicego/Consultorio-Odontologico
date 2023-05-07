package com.example.ProyectorIntegradorRenatoBicego.repository;

import com.example.ProyectorIntegradorRenatoBicego.models.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
    @Override
    <S extends Domicilio> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<Domicilio> findById(Long aLong);

    @Override
    List<Domicilio> findAll();
}
