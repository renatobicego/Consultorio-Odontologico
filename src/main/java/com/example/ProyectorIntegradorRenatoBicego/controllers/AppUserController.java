package com.example.ProyectorIntegradorRenatoBicego.controllers;

import com.example.ProyectorIntegradorRenatoBicego.ProyectorIntegradorRenatoBicegoApplication;
import com.example.ProyectorIntegradorRenatoBicego.models.login.AppUser;
import com.example.ProyectorIntegradorRenatoBicego.services.AppUserService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class AppUserController {
    private final AppUserService appUserService;
    private static final Logger logger = Logger.getLogger(AppUserController.class);

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/username")
    public AppUser getUsuarioPorUsername(@PathVariable String username){
        logger.info("Obteniendo usuario");
        return appUserService.loadUserByUsername(username);
    }

    @PostMapping
    public AppUser postUsuario(@RequestBody AppUser appUser){
        logger.info("Creando usuario");
        return appUserService.saveUsuario(appUser);
    }
}
