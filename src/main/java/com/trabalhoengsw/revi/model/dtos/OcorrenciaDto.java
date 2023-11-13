package com.trabalhoengsw.revi.model.dtos;

import com.trabalhoengsw.revi.model.Cliente;
import com.trabalhoengsw.revi.model.Veiculo;

public class OcorrenciaDto {

    private String description;
    private Cliente cliente;
    private Veiculo veiculo;

    public OcorrenciaDto() {
    }

    public OcorrenciaDto(String description, Cliente cliente, Veiculo veiculo) {
        this.description = description;
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
}
