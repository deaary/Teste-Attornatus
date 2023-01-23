package com.api.gerenciarPessoas.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EnderecoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEndereco;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false)
    private Long cep;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, length = 100)
    private String cidade;

    @JsonIgnore
    @Column()
    private Integer idPessoa;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
