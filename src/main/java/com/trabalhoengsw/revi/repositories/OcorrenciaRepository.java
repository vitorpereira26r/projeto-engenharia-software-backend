package com.trabalhoengsw.revi.repositories;

import com.trabalhoengsw.revi.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {

    List<Ocorrencia> findByCliente_Email(String clienteEmail);
    List<Ocorrencia> findByVeiculo_Placa(String veiculoPlaca);
    List<Ocorrencia> findByData(String data);
}
