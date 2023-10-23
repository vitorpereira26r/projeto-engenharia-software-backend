package com.trabalhoengsw.revi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

import java.util.Objects;

@Entity
@Table(name = "tb_funcionarios")
public class Funcionario extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_funcionario")
    private Integer id;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    public Funcionario(String name, String cpf, String email, String password, boolean isAdmin, Integer id) {
        super(name, cpf, email, password);
        this.id = id;
        this.isAdmin = isAdmin;
    }

    public Funcionario() {
        super(null, null, null, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return super.getName();
    }

    public void setName(String name){
        super.setName(name);
    }

    public String getCpf(){
        return super.getCpf();
    }

    public void setCpf(String cpf){
        super.setCpf(cpf);
    }

    public String getEmail(){
        return super.getEmail();
    }

    public void setEmail(String email){
        super.setEmail(email);
    }

    public String getPassword(){
        return super.getPassword();
    }

    public void setPassword(String password){
        super.setPassword(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
