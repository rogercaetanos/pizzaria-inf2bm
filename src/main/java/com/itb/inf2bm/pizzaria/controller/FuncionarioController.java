package com.itb.inf2bm.pizzaria.controller;

import com.itb.inf2bm.pizzaria.exceptions.BadRequest;
import com.itb.inf2bm.pizzaria.model.Categoria;
import com.itb.inf2bm.pizzaria.services.CategoriaService;
import com.itb.inf2bm.pizzaria.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// @Controller                   // Exclusivo para web

@RestController                  // Exclusivo para api´s
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public FuncionarioController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    // ResponseEntity : Tipo especial de resposta (Uma forma de retornar qualquer tipo de model (Entity)
    // @GetMapping:     Utilizado para receber apenas "CONSULTAS", ou seja, RECUPERAÇÃO DE DADOS
    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {

        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }

    // @PostMapping: Utilizado para persistência de dados "INSERÇÃO", ou seja, CADASTRO DE DADOS
    // @RequestBody: Utilizado para receber qualquer  objeto completo do Front-End
    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
        categoria.setCodStatus(true);
        if(!categoria.validarCategoria()) {
            throw new BadRequest(categoria.getMensagemErro());
        }
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());
        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }



}
