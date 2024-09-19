package com.itb.inf2bm.pizzaria.services;

import com.itb.inf2bm.pizzaria.model.Categoria;


import java.util.List;

public interface CategoriaService {

    public Categoria salvarCategoria(Categoria categoria);
    public List<Categoria> listarTodasCategorias();
    public Categoria listarCategoriaPorId(Long id);
    public boolean deletarCategoria(Long id);
    public Categoria atualizarCategoria(Categoria categoria, Long id);

}
