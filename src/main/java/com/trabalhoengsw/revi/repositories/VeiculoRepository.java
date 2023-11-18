package com.trabalhoengsw.revi.repositories;

import com.trabalhoengsw.revi.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    Optional<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByCliente_Email(String clienteEmail);
}
