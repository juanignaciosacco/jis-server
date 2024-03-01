package com.jisdevelopment.server.models;

import com.jisdevelopment.server.dto.MailRegistroDTO;

public class MailBody {

    private String nombre;
    private String apellido;
    private String emailUsuario;
    private String asunto;
    private String mensaje;

    public MailBody(MailRegistroDTO mailRegistroDTO) {
        this.nombre = mailRegistroDTO.nombre();
        this.apellido = mailRegistroDTO.apellido();
        this.emailUsuario = mailRegistroDTO.emailUsuario();
        this.asunto = mailRegistroDTO.asunto();
        this.mensaje = mailRegistroDTO.mensaje();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
