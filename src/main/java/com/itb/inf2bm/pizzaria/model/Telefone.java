package com.itb.inf2bm.pizzaria.model;

public class Telefone {

    private Long id;
    private String numero;

    private String mensagemErro = "";
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarTelefone() {
        return isValid;
    }
}
