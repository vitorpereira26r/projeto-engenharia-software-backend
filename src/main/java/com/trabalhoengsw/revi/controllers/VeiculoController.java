package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.exceptions.DatabaseException;
import com.trabalhoengsw.revi.exceptions.ResourceNotFoundException;
import com.trabalhoengsw.revi.model.Funcionario;
import com.trabalhoengsw.revi.model.Veiculo;
import com.trabalhoengsw.revi.model.dtos.VeiculoGetDto;
import com.trabalhoengsw.revi.repositories.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController implements Controller<Veiculo> {

    @Autowired
    private VeiculoRepository veiculoRepository;

    private static ClienteController instancia;

    public static ClienteController getInstancia() {
        return instancia;
    }

    @Override
    @PostMapping("/create")
    public Veiculo createElement(@RequestBody Veiculo element) {
        if(isNotUnique(element)){
            throw new DatabaseException("Placa must be unique");
        }

        return veiculoRepository.save(element);
    }

    @Override
    @GetMapping("/get")
    public List<Veiculo> getElements() {
        return veiculoRepository.findAll();
    }

    @Override
    @GetMapping("/get/{id}")
    public Veiculo getElementById(@PathVariable Integer id) {
        return veiculoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id)
        );
    }

    @PostMapping("/get-placa")
    public Veiculo getByPlaca(@RequestBody VeiculoGetDto dto){
        return veiculoRepository.findByPlaca(dto.getPlaca()).orElseThrow(() -> new ResourceNotFoundException(dto.getPlaca()));
    }

    @PostMapping("/get-cliente-email")
    public List<Veiculo> getByCLiente(@RequestBody VeiculoGetDto dto){
        return veiculoRepository.findByCliente_Email(dto.getEmail());
    }

    @Override
    @PutMapping("/update/{id}")
    public Veiculo updateElement(@PathVariable Integer id, @RequestBody Veiculo element) {
        if(isNotUnique(element)){
            throw new DatabaseException("Placa must be unique");
        }

        try {
            Veiculo entity = veiculoRepository.getReferenceById(id);
            updateData(entity, element);
            return veiculoRepository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        try{
            veiculoRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Veiculo entity, Veiculo element){
        entity.setAno(element.getAno());
        entity.setModelo(element.getModelo());
        entity.setPlaca(element.getPlaca());
    }

    private boolean isNotUnique(Veiculo veiculo){
        Optional<Veiculo> existingPlaca = veiculoRepository.findByPlaca(veiculo.getPlaca());

        return existingPlaca.isPresent() && existingPlaca.get().getId() != veiculo.getId();
    }
}
