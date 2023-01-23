package com.api.gerenciarPessoas.Repositories;

import com.api.gerenciarPessoas.Models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

}
