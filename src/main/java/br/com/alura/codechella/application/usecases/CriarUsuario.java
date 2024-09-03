package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.UsuarioDto;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;


public class CriarUsuario {

    private final RepositorioDeUsuarioJpa repositorio;

    public CriarUsuario(RepositorioDeUsuarioJpa repositorio) {
        this.repositorio = repositorio;
    }


    public Usuario cadastrarUsuario(UsuarioDto usuarioDto) {
        return repositorio.cadastrarUsuario(new Usuario(
                usuarioDto.cpf(),
                usuarioDto.nome(),
                usuarioDto.nascimento(),
                usuarioDto.email()));
//        return repositorio.cadastrarUsuario(new Usuario.Builder()
//                .cpf(usuarioDto.cpf())
//                .nome(usuarioDto.nome())
//                .nascimento(usuarioDto.nascimento())
//                .build());
    }
}
