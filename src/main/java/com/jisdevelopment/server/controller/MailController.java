package com.jisdevelopment.server.controller;

import com.jisdevelopment.server.dto.MailRegistroDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jisdevelopment.server.models.MailBody;
import com.jisdevelopment.server.services.EmailService;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contacto")
    public ResponseEntity<?> sendMail(@RequestBody @Valid MailRegistroDTO mail, BindingResult result) {

        if (result.hasErrors()){
            return validaciones(result);
        }

        MailBody mailBody = new MailBody(mail);

        String message = "<b>Datos de contacto: </b>" + "<br/><br/><br/>" + "<b>Nombre: </b>" + mailBody.getNombre() +
                "<br/>" + "<b>Apellido: </b>" + mailBody.getApellido() + "<br/>" + "<b>E-mail: </b>" +
                mailBody.getEmailUsuario() + "<hr/><br/>" + "<b>Mensaje: </b><br/>" + mailBody.getMensaje();

        emailService.sendListEmail(mailBody.getAsunto(), message, mailBody.getEmailUsuario());

        return ResponseEntity.ok("Correo enviado con exito!");
    }

    private ResponseEntity<?> validaciones(BindingResult result) {
        HashMap<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(result);
    }

}
