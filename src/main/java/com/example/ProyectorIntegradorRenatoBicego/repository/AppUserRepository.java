package com.example.ProyectorIntegradorRenatoBicego.repository;

import com.example.ProyectorIntegradorRenatoBicego.models.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    @Override
    <S extends AppUser> S save(S entity);
}
