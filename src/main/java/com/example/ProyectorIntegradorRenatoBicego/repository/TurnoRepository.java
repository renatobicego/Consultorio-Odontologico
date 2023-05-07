package com.example.ProyectorIntegradorRenatoBicego.repository;

import com.example.ProyectorIntegradorRenatoBicego.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    @Override
    <S extends Turno> S save(S entity);

    @Override
    void deleteById(Long aLong);
    @Override
    List<Turno> findAll();

    @Override
    Optional<Turno> findById(Long aLong);
}
