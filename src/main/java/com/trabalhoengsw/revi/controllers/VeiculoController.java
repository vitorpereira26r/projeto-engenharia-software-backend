package com.trabalhoengsw.revi.controllers;

import com.trabalhoengsw.revi.model.Veiculo;
import com.trabalhoengsw.revi.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.get();
    }

    @Override
    @PutMapping("/update/{id}")
    public Veiculo updateElement(@PathVariable Integer id, @RequestBody Veiculo element) {
        Veiculo entity = veiculoRepository.getReferenceById(id);
        updateData(entity, element);
        return veiculoRepository.save(entity);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable Integer id) {
        veiculoRepository.deleteById(id);
    }

    private void updateData(Veiculo entity, Veiculo element){
        entity.setAno(element.getAno());
        entity.setModelo(element.getModelo());
        entity.setPlaca(element.getPlaca());
    }
}
