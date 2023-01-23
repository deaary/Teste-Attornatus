package com.api.gerenciarPessoas.Repositories;

import com.api.gerenciarPessoas.Models.EnderecoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa,Integer> {

    @Query(value = "SELECT * FROM ENDERECO_PESSOA WHERE ID_PESSOA =:idPessoa", nativeQuery = true)
    List<EnderecoPessoa> findAdressByIdPessoa(Integer idPessoa);
}
