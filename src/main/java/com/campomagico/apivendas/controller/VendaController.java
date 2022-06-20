package com.campomagico.apivendas.controller;

import com.campomagico.apivendas.model.VendaModel;
import com.campomagico.apivendas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/venda", produces = MediaType.APPLICATION_JSON_VALUE)
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping
    public VendaModel create (@RequestBody VendaModel vendaModel){
        return vendaRepository.save(vendaModel);
    }

    @PutMapping
    public void update (@RequestBody VendaModel vendaModel){
        if(vendaModel.getId() > 0)
        vendaRepository.save(vendaModel);
    }

    @GetMapping
    public List<VendaModel> list(){
        return vendaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        vendaRepository.deleteById(id);
    }
}
