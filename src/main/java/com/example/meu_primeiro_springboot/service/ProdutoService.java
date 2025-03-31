package com.example.meu_primeiro_springboot.service;

import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto do id: "+ id +" nao encontrado"));
    }

    public void delete(Long id){
        if(!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com id "+ id +" nao encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

}
