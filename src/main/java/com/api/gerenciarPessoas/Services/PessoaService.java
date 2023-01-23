package com.api.gerenciarPessoas.Services;

import com.api.gerenciarPessoas.Models.Pessoa;
import com.api.gerenciarPessoas.Repositories.EnderecoPessoaRepository;
import com.api.gerenciarPessoas.Repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoPessoaRepository enderecoPessoaRepository;

    public List<Pessoa> mostrarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa mostrarPessoaPeloId(Integer idPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        return pessoa.orElseThrow(
                () -> new EntityNotFoundException("Pessoa não cadastrada: " + idPessoa)
        );
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) throws DataIntegrityViolationException {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa editarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


}
