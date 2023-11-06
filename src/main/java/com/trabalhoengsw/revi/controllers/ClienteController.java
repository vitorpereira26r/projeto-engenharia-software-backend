package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Cliente newCliente = clienteRepository.save(element);
        return newCliente;
    }

    @Override
    @GetMapping("/get")
    public List<Cliente> getElements() {
        return clienteRepository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Cliente getElementById(@PathVariable Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.get();
    }

    @Override
    @PutMapping("/update/{id}")
    public Cliente updateElement(@PathVariable Integer id, @RequestBody Cliente element) {
        Cliente obj = clienteRepository.getReferenceById(id);
        updateData(obj, element);
        Cliente entity = clienteRepository.save(obj);
        return entity;
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }

    private void updateData(Cliente obj, Cliente entity){
        obj.setName(entity.getName());
        obj.setCpf(entity.getCpf());
        obj.setEmail(entity.getEmail());
    }
}
