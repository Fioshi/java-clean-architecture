package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;

public class ExcluirUsuario {

    private final RepositorioDeUsuario repository;

    public ExcluirUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public void excluir(Long id){
        repository.exclusao(id);
    }
}
