package com.trabalhoengsw.revi.config;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Funcionario;
import com.trabalhoengsw.revi.model.Ocorrencia;
import com.trabalhoengsw.revi.model.Veiculo;
import com.trabalhoengsw.revi.repositories.ClienteRepository;
import com.trabalhoengsw.revi.repositories.FuncionarioRepository;
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
    private final FuncionarioRepository funcionarioRepository;
    private final VeiculoRepository veiculoRepository;
    private final OcorrenciaRepository ocorrenciaRepository;

    public DataInitializer(ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository, VeiculoRepository veiculoRepository, OcorrenciaRepository ocorrenciaRepository) {
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.veiculoRepository = veiculoRepository;
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    @Override
    public void run(String... args) {
        Cliente cliente1 = new Cliente("Hulk do galo", "1234567890", "hulk7givanildo@gmail.com", "paunocumaria");
        Cliente cliente2 = new Cliente("Cliente 2", "1111111111", "cliente2@gmail.com", "senha2");

        // Salvar clientes no banco de dados
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);

        // Criar funcionários
        Funcionario funcionario1 = new Funcionario("Funcionário 1", "9999999999", "funcionario1@gmail.com", "senha1", true);
        Funcionario funcionario2 = new Funcionario("Funcionário 2", "8888888888", "funcionario2@gmail.com", "senha2", false);

        // Salvar funcionários no banco de dados
        funcionarioRepository.save(funcionario1);
        funcionarioRepository.save(funcionario2);

        // Criar veículos
        Veiculo veiculo1 = new Veiculo("ABC1234", "Ferrari", Year.now(), cliente1);
        Veiculo veiculo2 = new Veiculo("XYZ5678", "Tesla", Year.now(), cliente2);

        // Salvar veículos no banco de dados
        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);

        // Criar ocorrências
        Ocorrencia ocorrencia1 = new Ocorrencia(Instant.now(), "Batida de carro", cliente1, veiculo1);
        Ocorrencia ocorrencia2 = new Ocorrencia(Instant.now(), "Roubo de veículo", cliente2, veiculo2);

        // Salvar ocorrências no banco de dados
        ocorrenciaRepository.save(ocorrencia1);
        ocorrenciaRepository.save(ocorrencia2);
    }
}
