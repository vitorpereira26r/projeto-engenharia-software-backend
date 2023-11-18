package com.trabalhoengsw.revi.model.dtos;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Veiculo;

import java.time.Instant;

public class OcorrenciaDto {

    private String description;
    private String data;
    private Cliente cliente;
    private Veiculo veiculo;

    public OcorrenciaDto() {

    }

    public OcorrenciaDto(String description, String data, Cliente cliente, Veiculo veiculo) {
        this.description = description;
        this.data = data;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
