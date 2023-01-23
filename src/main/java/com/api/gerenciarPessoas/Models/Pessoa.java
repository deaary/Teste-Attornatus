package com.api.gerenciarPessoas.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPessoa;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private EnderecoPessoa enderecos;

    public EnderecoPessoa getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(EnderecoPessoa enderecos) {
        this.enderecos = enderecos;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
