package com.example.ProyectorIntegradorRenatoBicego.services;

import com.example.ProyectorIntegradorRenatoBicego.login.PasswordEncoder;
import com.example.ProyectorIntegradorRenatoBicego.models.login.AppUser;
import com.example.ProyectorIntegradorRenatoBicego.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username).get();
    }

     public AppUser saveUsuario(AppUser appUser){
        String password = passwordEncoder.bCryptPasswordEncoder().encode(appUser.getPassword());
        appUser.setPassword(password);
        return appUserRepository.save(appUser);
     }
}
