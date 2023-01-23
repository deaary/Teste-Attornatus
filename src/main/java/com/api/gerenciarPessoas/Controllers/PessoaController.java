package com.api.gerenciarPessoas.Controllers;

import com.api.gerenciarPessoas.Models.Pessoa;
import com.api.gerenciarPessoas.Services.PessoaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("services")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/pessoas")
    public List<Pessoa> mostrarTodasPessoas() {
        List<Pessoa> pessoas = pessoaService.mostrarTodasPessoas();
        return pessoas;
    }

    @GetMapping("/pessoas/{idPessoa}")
    public ResponseEntity<Pessoa> mostrarPessoaPeloId(@PathVariable Integer idPessoa) {
        Pessoa pessoa = pessoaService.mostrarPessoaPeloId(idPessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/pessoas-cadastro")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.cadastrarPessoa(pessoa);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(pessoa.getIdPessoa()).toUri();
        return ResponseEntity.created(novaUri).body(pessoa);
    }

    @PutMapping("/pessoas/{idPessoa}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Integer idPessoa,
                                               @RequestBody Pessoa pessoa) {
        pessoa.setIdPessoa(idPessoa);
        pessoa.setEnderecos(pessoa.getEnderecos());
        pessoaService.editarPessoa(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }


}
