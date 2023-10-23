package com.trabalhoengsw.revi.config;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Ocorrencia;
import com.trabalhoengsw.revi.model.Veiculo;
import com.trabalhoengsw.revi.repositories.ClienteRepository;
import com.trabalhoengsw.revi.repositories.OcorrenciaRepository;
import com.trabalhoengsw.revi.repositories.VeiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public DataInitializer(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository, OcorrenciaRepository ocorrenciaRepository) {
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public void run(String... args) {
        Cliente cliente = new Cliente("Hulk do galo", "1234567890", "hulk7givanildo@gmail.com", "paunocumaria");

        Veiculo veiculo = new Veiculo("ABC1234", "Ferrari", Year.now(), cliente);
        veiculo.setCliente(cliente);

        Ocorrencia ocorrencia = new Ocorrencia(Instant.now(), "Batida de carro", cliente, veiculo);

        veiculo.addOcorrenciaToList(ocorrencia);

        cliente.addOcorrenciaToList(ocorrencia);
        cliente.addVeiculo(veiculo);

        clienteRepository.save(cliente);
        veiculoRepository.save(veiculo);
        ocorrenciaRepository.save(ocorrencia);
    }
}
