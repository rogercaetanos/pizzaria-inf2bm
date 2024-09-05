package com.itb.inf2bm.pizzaria.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorMessage {

    private LocalDateTime timestamp;
    private String [] messages;
    private HttpStatus title;
    private int status;

    // Método Construtor: É possível criar um objeto passando informações no momento da criação.
    // Para tal, utilizamos os métodos construtores. Uma classe pode ter 1 ou mais construtores.
    // O método construtor possui o mesmo nome da classe.
    // Regra geral:

    public ErrorMessage(LocalDateTime timestamp, String[] messages, HttpStatus title) {
        this.timestamp = timestamp;
        this.messages = messages;
        this.title = title;
        this.status = title.value();
    }
}
