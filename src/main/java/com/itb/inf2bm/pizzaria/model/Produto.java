package com.itb.inf2bm.pizzaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    // Encapsulamento:  Para prover o encapsulamento devemos seguir alguns passos:
    // 1º-> Alterar o modificador de acesso dos atributos: public -> private ou  public -> protected
    // 2º-> Criar os métodos Setter´s e Getter´s
    // Obs: Set -> Atribuir valor ao atributo
    //      Get -> Recuperar valor do atributo

    // Para cada atributo teremos o set e get correspondente
    // Exemplo de nomeação :  setId |  getId

    // Modificadores de Acesso (atributos ou métodos)

    // public -      Acesso livre para qualquer classe
    // protected -   Acesso livre dentro da estrutura de herança, apenas classes "filhas" tem acesso
    // private -     Acesso livre "apenas" dentro da própria classe


    @Id                                                           // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)           // AUTO INCREMENTO DO SQL-SERVER
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 255)
    private String descricao;
    @Column(nullable = true, length = 45)
    private String tipo;
    @Column(nullable = true)
    private int quantidadeEstoque;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoVenda;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double precoCompra;
    private boolean codStatus;


    // Atributos de apoio

    @Transient                            // ATRIBUTOS QUE NÃO CORRESPONDE A UMA COLUNA
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }
    public boolean getCodStatus() {
        return codStatus;
    }
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarProduto() {
        if(precoVenda < 0 ){
            mensagemErro += "O preço de venda do produto não pode ser menor que zero:";
            precoVenda = 0;
            isValid = false;
        }
        if (precoCompra < 0) {
            mensagemErro += "O preço de compra do produto não pode ser menor que zero:";
            precoCompra = 0;
            isValid = false;
        }
        return isValid;
    }

}
