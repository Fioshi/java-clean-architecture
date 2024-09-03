package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.infra.controller.UsuarioDto;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;

public class AtualizarUsuario {

    private final RepositorioDeUsuarioJpa repository;

    public AtualizarUsuario(RepositorioDeUsuarioJpa repository) {
        this.repository = repository;
    }

    public UsuarioDto atualizarUsuario(Long id, UsuarioDto dto){
        var usuario = repository.encontrarPorId(id);
        usuario.atualizar(dto);
        return dto;
    }
}
