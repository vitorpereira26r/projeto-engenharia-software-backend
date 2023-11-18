package com.trabalhoengsw.revi.model.dtos;

public class VeiculoGetDto {

    private String placa;

    private String email;

    public VeiculoGetDto() {
    }

    public VeiculoGetDto(String placa, String email) {
        this.placa = placa;
        this.email = email;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
