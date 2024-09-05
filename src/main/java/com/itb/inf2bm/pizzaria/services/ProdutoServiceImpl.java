package com.itb.inf2bm.pizzaria.services;

import com.itb.inf2bm.pizzaria.exceptions.BadRequest;
import com.itb.inf2bm.pizzaria.exceptions.NotFound;
import com.itb.inf2bm.pizzaria.model.Produto;
import com.itb.inf2bm.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    // final: Um atributo que não será alterado, valor final definitivo.

   //  @Autowired  injeção de dependência, não é muito aconselhável mas funciona
   // private  ProdutoRepository produtoRepository;
    private final ProdutoRepository produtoRepository;

    // Utilizando o construtor da classe para INJETAR A DEPENDÊNCIA.
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional           // Garante que a operação será executada do começo ao fim sem problemas. OU FAZ TUDO OU NÃO FAZ NADA
    public Produto salvarProduto(Produto produto) {
        if(!produto.validarProduto()) {
            throw new BadRequest(produto.getMensagemErro());
        }
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarTodosProdutos() {

        return produtoRepository.findAll();
    }

    @Override
    public Produto listarProdutoPorId(Long id) {
        try{
            return  produtoRepository.findById(id).get();
        }catch (Exception ex){
            throw new NotFound("Produto não encontrado com o id " + id);
        }
    }

    @Override
    @Transactional
    public boolean deletarProduto(Long id) {

        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        }else {
            throw new NotFound("Produto não encontrado com o id " + id);
        }
        return true;
    }
    @Override
    @Transactional
    public Produto atualizarProduto(Produto produto, Long id) {

        try {
            if(!produto.validarProduto()) {
                throw new BadRequest(produto.getMensagemErro());
            }
            Produto produtoBd = produtoRepository.findById(id).get();
            produtoBd.setNome(produto.getNome());
            produtoBd.setTipo(produto.getTipo());
            produtoBd.setDescricao(produto.getDescricao());
            produtoBd.setPrecoVenda(produto.getPrecoVenda());
            produtoBd.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            return produtoRepository.save(produtoBd); // save : dupla função -> update para objeto existente
        } catch (Exception ex) {
            throw new NotFound("Produto não encontrado com o id " + id);
        }

    }
}
