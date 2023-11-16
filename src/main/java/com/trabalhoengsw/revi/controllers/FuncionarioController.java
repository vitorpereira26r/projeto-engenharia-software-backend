package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.exceptions.DatabaseException;
import com.trabalhoengsw.revi.exceptions.LoginFail;
import com.trabalhoengsw.revi.exceptions.ResourceNotFoundException;
import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Funcionario;
import com.trabalhoengsw.revi.model.dtos.LoginDto;
import com.trabalhoengsw.revi.repositories.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
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
        if(isNotUnique(element)){
            throw new DatabaseException("Cpf, email and name must be unique");
        }

        return funcionarioRepository.save(element);
    }

    @PostMapping("/login")
    public ResponseEntity<Funcionario> fazerLogin(@RequestBody LoginDto dto){
        Funcionario funcionario = funcionarioRepository.findByName(dto.getName()).orElseThrow(() -> new ResourceNotFoundException("Funcionario de name " + dto.getName() + " nao encontrado"));

        if(!funcionario.getPassword().equals(dto.getPassword())){
            throw new LoginFail("Password is incorrect");
        }

        return ResponseEntity.ok(funcionario);
    }

    @Override
    @GetMapping("/get")
    public List<Funcionario> getElements() {
        return funcionarioRepository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Funcionario getElementById(@PathVariable Integer id) {
        return funcionarioRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id)
        );
    }

    @Override
    @PutMapping("/update/{id}")
    public Funcionario updateElement(@PathVariable Integer id, @RequestBody Funcionario element) {
        if(isNotUnique(element)){
            throw new DatabaseException("Cpf, email and name must be unique");
        }

        try{
            Funcionario entity = funcionarioRepository.getReferenceById(id);
            updateData(entity, element);
            return funcionarioRepository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        try{
            funcionarioRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Funcionario entity, Funcionario element){
        entity.setName(element.getName());
        entity.setCpf(element.getCpf());
        entity.setEmail(element.getEmail());
    }

    private boolean isNotUnique(Funcionario funcionario){
        Optional<Funcionario> existingName = funcionarioRepository.findByName(funcionario.getName());
        Optional<Funcionario> existingCpf = funcionarioRepository.findByCpf(funcionario.getCpf());
        Optional<Funcionario> existingEmail = funcionarioRepository.findByEmail(funcionario.getEmail());

        return existingName.isPresent() || existingCpf.isPresent() || existingEmail.isPresent();
    }
}
