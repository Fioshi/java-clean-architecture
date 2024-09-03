package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuarioJpa repository;

    public ListarUsuarios(RepositorioDeUsuarioJpa repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios(){
        return this.repository.listarTodos();
    }
}
