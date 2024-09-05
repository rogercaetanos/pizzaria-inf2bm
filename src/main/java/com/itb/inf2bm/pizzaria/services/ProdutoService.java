package com.itb.inf2bm.pizzaria.services;

import com.itb.inf2bm.pizzaria.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto salvarProduto(Produto produto);
    public List<Produto> listarTodosProdutos();
    public Produto listarProdutoPorId(Long id);
    public boolean deletarProduto(Long id);
    public Produto atualizarProduto(Produto produto, Long id);


}
