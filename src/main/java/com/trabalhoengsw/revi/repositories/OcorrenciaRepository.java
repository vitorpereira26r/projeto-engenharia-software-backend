package com.trabalhoengsw.revi.repositories;

import com.trabalhoengsw.revi.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {
}
