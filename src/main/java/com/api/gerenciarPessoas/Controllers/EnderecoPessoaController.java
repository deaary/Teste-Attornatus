package com.api.gerenciarPessoas.Controllers;

import com.api.gerenciarPessoas.Models.EnderecoPessoa;
import com.api.gerenciarPessoas.Models.Pessoa;
import com.api.gerenciarPessoas.Services.EnderecoPessoaService;
import com.api.gerenciarPessoas.Services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("services")
public class EnderecoPessoaController {

    @Autowired
    EnderecoPessoaService enderecoPessoaService;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/enderecos/{idPessoa}")
    public List<EnderecoPessoa> mostrarEnderecosPessoa(@PathVariable Integer idPessoa) {
        List<EnderecoPessoa> enderecoPessoa = enderecoPessoaService.mostrarEnderecosPessoa(idPessoa);
        return enderecoPessoa;
    }

    @GetMapping("/enderecos-principal/{idPessoa}")
    public ResponseEntity<EnderecoPessoa> mostrarEnderecoPrincipal(@PathVariable Integer idPessoa){
        EnderecoPessoa enderecoPessoa = enderecoPessoaService.mostrarEnderecoPrincipal(idPessoa);
        return ResponseEntity.ok().body(enderecoPessoa);
    }

    @PostMapping("/enderecos/{idPessoa}")
    public ResponseEntity<EnderecoPessoa> criarEnderecoPessoa(@PathVariable Integer idPessoa,
                                                              @RequestBody EnderecoPessoa enderecoPessoa) {
        enderecoPessoa = enderecoPessoaService.criarEnderecoPessoa(idPessoa, enderecoPessoa);

        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(enderecoPessoa.getIdEndereco()).toUri();
        return ResponseEntity.created(novaUri).body(enderecoPessoa);
    }
}
