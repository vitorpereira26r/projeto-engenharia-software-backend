package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Funcionario;
import com.trabalhoengsw.revi.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements Controller<Funcionario>{

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private static ClienteController instancia;

    public static ClienteController getInstancia() {
        return instancia;
    }

    @Override
    @PostMapping("/create")
    public Funcionario createElement(@RequestBody Funcionario element) {
        Funcionario newFuncionario = funcionarioRepository.save(element);
        return newFuncionario;
    }

    @Override
    @GetMapping("/get")
    public List<Funcionario> getElements() {
        return funcionarioRepository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Funcionario getElementById(@PathVariable Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.get();
    }

    @Override
    @PutMapping("/update/{id}")
    public Funcionario updateElement(@PathVariable Integer id, @RequestBody Funcionario element) {
        Funcionario entity = funcionarioRepository.getReferenceById(id);
        updateData(entity, element);
        return funcionarioRepository.save(entity);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        funcionarioRepository.deleteById(id);
    }

    private void updateData(Funcionario entity, Funcionario element){
        entity.setName(element.getName());
        entity.setCpf(element.getCpf());
        entity.setEmail(element.getEmail());
    }
}
