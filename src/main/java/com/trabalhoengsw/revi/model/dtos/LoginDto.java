package com.trabalhoengsw.revi.model.dtos;

import com.trabalhoengsw.revi.model.Funcionario;

public class LoginDto {

    private String email;

    private String password;

    public LoginDto() {
    }

    public LoginDto(Funcionario funcionario){
        this.email = funcionario.getName();
        this.password = funcionario.getPassword();
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
