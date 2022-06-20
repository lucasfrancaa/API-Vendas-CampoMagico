package com.campomagico.apivendas.controller;


import com.campomagico.apivendas.model.FuncionarioModel;
import com.campomagico.apivendas.model.ProdutoModel;
import com.campomagico.apivendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ProdutoModel create (@RequestBody ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    @PutMapping
    public void update (@RequestBody ProdutoModel produtoModel){
        if(produtoModel.getId() > 0)
        produtoRepository.save(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> list(){
        return produtoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
