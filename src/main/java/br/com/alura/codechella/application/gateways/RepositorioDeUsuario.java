package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    Usuario encontrarPorId(Long id);

    List<Usuario> listarTodos();

    Usuario atualizar(Long id);

    void exclusao(Long id);
}
