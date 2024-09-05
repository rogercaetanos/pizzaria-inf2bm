package com.itb.inf2bm.pizzaria;

import com.itb.inf2bm.pizzaria.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzariaApplication.class, args);

		System.out.println("Meu primeiro projeto Spring Boot");

		Produto p1 = new Produto();
		// p1.precoVenda = -56.00;  acesso não permitido - "modificador de acesso" agora é private
		// p1.setPrecoVenda(-56); ainda é possível atribuir valores inválidos, entretanto agora tenho um método
		//                        onde é possível criar algoritmos de validações
		// System.out.println("Valor da pizza é " + p1.getPrecoVenda());
		// Escolhemos criar um método ESPECÍFICO na própria classe responsável pelas validações
		// Veja:

		p1.setPrecoVenda(-56);
		p1.setPrecoCompra(-10);
		if(!p1.validarProduto()) {
			System.out.println(p1.getMensagemErro());
		}


	}

}
