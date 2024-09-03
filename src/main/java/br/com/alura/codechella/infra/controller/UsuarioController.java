package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AtualizarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AtualizarUsuario atualizarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AtualizarUsuario atualizarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.atualizarUsuario = atualizarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @PostMapping
    public UsuarioDto criarUsuario(@RequestBody UsuarioDto dto, UriComponentsBuilder uriBuilder){
        var usuario = criarUsuario.cadastrarUsuario(dto);
        return new UsuarioDto(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios(){
        return listarUsuarios.listarUsuarios().stream().map(
                user -> new UsuarioDto(user.getCpf(), user.getNome(), user.getNascimento(), user.getEmail())
        ).toList();
    }

    @PutMapping("{id}")
    public UsuarioDto atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto dto){
        return atualizarUsuario.atualizarUsuario(id, dto);
    }

    @DeleteMapping("{id}")
    public void excluirUsuario(@PathVariable Long id){
        excluirUsuario.excluir(id);
    }
}
