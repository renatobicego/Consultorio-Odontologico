package com.example.ProyectorIntegradorRenatoBicego.repository;

import com.example.ProyectorIntegradorRenatoBicego.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Override
    <S extends Paciente> S save(S entity);

    @Override
    void deleteById(Long aLong);

    @Override
    Optional<Paciente> findById(Long aLong);

    @Override
    List<Paciente> findAll();
}
