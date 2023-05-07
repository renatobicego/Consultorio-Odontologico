package com.example.ProyectorIntegradorRenatoBicego.controllers;
import com.example.ProyectorIntegradorRenatoBicego.login.JwtUtil;
import com.example.ProyectorIntegradorRenatoBicego.models.login.AppUser;
import com.example.ProyectorIntegradorRenatoBicego.models.login.AuthenticationRequest;
import com.example.ProyectorIntegradorRenatoBicego.models.login.AuthenticationResponse;
import com.example.ProyectorIntegradorRenatoBicego.services.AppUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserService appUserService;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private JwtUtil jwtUtil;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        logger.info("Autenticando usuario");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            logger.error(e.getMessage());
            throw new Exception("Incorrect", e);
        }
        final AppUser userDetails = appUserService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails));
    }

    @RequestMapping(value = "/authenticate")
    public ResponseEntity<AppUser> getUsuarioLogueado(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) auth.getPrincipal();
        return ResponseEntity.ok(user);
    }

}
