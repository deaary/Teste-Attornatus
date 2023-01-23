package com.api.gerenciarPessoas.Services;

import com.api.gerenciarPessoas.Models.EnderecoPessoa;
import com.api.gerenciarPessoas.Models.Pessoa;
import com.api.gerenciarPessoas.Repositories.EnderecoPessoaRepository;
import com.api.gerenciarPessoas.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoPessoaService {

    @Autowired
    EnderecoPessoaRepository enderecoPessoaRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<EnderecoPessoa> mostrarEnderecosPessoa(Integer idPessoa) {
        return enderecoPessoaRepository.findAdressByIdPessoa(idPessoa);
    }

    public EnderecoPessoa mostrarEnderecoPrincipal(Integer idPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        EnderecoPessoa enderecoPessoa = pessoa.get().getEnderecos();

        return enderecoPessoa;
    }

    public EnderecoPessoa criarEnderecoPessoa(Integer idPessoa, EnderecoPessoa enderecoPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);

        enderecoPessoa.setIdPessoa(idPessoa);
        enderecoPessoaRepository.save(enderecoPessoa);

        pessoa.get().setEnderecos(enderecoPessoa);
        pessoaRepository.save(pessoa.get());

        return enderecoPessoa;
    }

}
