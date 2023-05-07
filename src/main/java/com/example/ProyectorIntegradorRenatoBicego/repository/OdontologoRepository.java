package com.example.ProyectorIntegradorRenatoBicego.repository;

import com.example.ProyectorIntegradorRenatoBicego.models.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
    @Override
    Optional<Odontologo> findById(Long aLong);

    @Override
    List<Odontologo> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    <S extends Odontologo> S save(S entity);
}
