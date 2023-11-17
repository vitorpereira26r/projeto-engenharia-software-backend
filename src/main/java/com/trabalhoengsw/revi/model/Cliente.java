package com.trabalhoengsw.revi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_clientes")
public class Cliente extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Veiculo> veiculos;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
    private List<Ocorrencia> ocorrencias;

    public Cliente(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
        this.veiculos = new ArrayList<>();
        this.ocorrencias = new ArrayList<>();
    }

    public Cliente() {
        super();
        this.veiculos = new ArrayList<>();
        this.ocorrencias = new ArrayList<>();
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void addOcorrenciaToList(Ocorrencia ocorrencia){
        ocorrencias.add(ocorrencia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", veiculos=" + veiculos +
                '}';
    }
}
