package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.UsuarioDto;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;

public class EncontrarUsuario {

    private final RepositorioDeUsuario repository;

    public EncontrarUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public Usuario encontrar (Long id) {
        return repository.encontrarPorId(id);
    }
}
