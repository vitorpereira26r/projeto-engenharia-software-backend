package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.exceptions.DatabaseException;
import com.trabalhoengsw.revi.exceptions.ResourceNotFoundException;
import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Funcionario;
import com.trabalhoengsw.revi.model.dtos.ClienteGetDto;
import com.trabalhoengsw.revi.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements Controller<Cliente>{

    @Autowired
    private ClienteRepository clienteRepository;

    private static ClienteController instancia;

    public static ClienteController getInstancia() {
        return instancia;
    }

    @Override
    @PostMapping("/create")
    public Cliente createElement(@RequestBody Cliente element) {
        if(isNotUnique(element)){
            throw new DatabaseException("Cpf, email and name must be unique");
        }

        return clienteRepository.save(element);
    }

    @Override
    @GetMapping("/get")
    public List<Cliente> getElements() {
        return clienteRepository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Cliente getElementById(@PathVariable Integer id) {
        return clienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id)
        );
    }

    @GetMapping("/get-nome")
    public Cliente getByNome(@RequestBody ClienteGetDto dto){
        return clienteRepository.findByName(dto.getNome()).orElseThrow(() -> new ResourceNotFoundException(dto.getNome()));
    }

    @GetMapping("/get-cpf")
    public Cliente getByCpf(@RequestBody ClienteGetDto dto){
        return clienteRepository.findByCpf(dto.getCpf()).orElseThrow(() -> new ResourceNotFoundException(dto.getCpf()));
    }

    @Override
    @PutMapping("/update/{id}")
    public Cliente updateElement(@PathVariable Integer id, @RequestBody Cliente element) {
        if(isNotUnique(element)){
            throw new DatabaseException("Cpf, email and name must be unique");
        }

        try{
            Cliente obj = clienteRepository.getReferenceById(id);
            updateData(obj, element);
            return clienteRepository.save(obj);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        try{
            clienteRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Cliente obj, Cliente entity){
        obj.setName(entity.getName());
        obj.setCpf(entity.getCpf());
        obj.setEmail(entity.getEmail());
    }

    private boolean isNotUnique(Cliente cliente){
        Optional<Cliente> existingName = clienteRepository.findByName(cliente.getName());
        Optional<Cliente> existingCpf = clienteRepository.findByCpf(cliente.getCpf());
        Optional<Cliente> existingEmail = clienteRepository.findByEmail(cliente.getEmail());

        return existingName.isPresent() || existingCpf.isPresent() || existingEmail.isPresent();
    }
}
