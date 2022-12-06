package com.example.exemplosspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.exemplosspring.domain.Produto;
import com.example.exemplosspring.repository.ProdutoRepository;
import com.example.exemplosspring.service.exceptions.DataIntegrityException;
import com.example.exemplosspring.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto buscarProduto(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException( "Objeto não encontrado. ID: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Produto inserirProduto(Produto obj) {
		obj.setId(null);
		return produtoRepository.save(obj);
	}
}
