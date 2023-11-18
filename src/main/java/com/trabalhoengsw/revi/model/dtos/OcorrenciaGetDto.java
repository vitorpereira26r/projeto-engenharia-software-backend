package com.trabalhoengsw.revi.model.dtos;

public class OcorrenciaGetDto {

    private String clienteEmail;
    private String veiculoPlaca;
    private String data;

    public OcorrenciaGetDto() {
    }

    public OcorrenciaGetDto(String clienteEmail, String veiculoPlaca, String data) {
        this.clienteEmail = clienteEmail;
        this.veiculoPlaca = veiculoPlaca;
        this.data = data;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getVeiculoPlaca() {
        return veiculoPlaca;
    }

    public void setVeiculoPlaca(String veiculoPlaca) {
        this.veiculoPlaca = veiculoPlaca;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
