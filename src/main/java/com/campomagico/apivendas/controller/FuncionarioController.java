package com.campomagico.apivendas.controller;

import com.campomagico.apivendas.model.FuncionarioModel;
import com.campomagico.apivendas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    public FuncionarioModel create (@RequestBody FuncionarioModel funcionarioModel){

        return funcionarioRepository.save(funcionarioModel);
    }

    @PutMapping
    public void update (@RequestBody FuncionarioModel funcionarioModel){
        if(funcionarioModel.getId() > 0)
            funcionarioRepository.save(funcionarioModel);
    }

    @GetMapping
    public List<FuncionarioModel> list(){
        return funcionarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        funcionarioRepository.deleteById(id);
    }
}
