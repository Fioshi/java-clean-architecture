package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.controller.UsuarioDto;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        var usuarioEntity = mapper.mapearUsuarioParaEntidade(usuario);
        repositorio.save(usuarioEntity);
        return usuario;
    }

    @Override
    public Usuario encontrarPorId(Long id) {
        return mapper.mapearUsuarioParaDomain(repositorio.getReferenceById(id));
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream().map(mapper::mapearUsuarioParaDomain).toList();
    }

    @Override
    public Usuario atualizar(Long id) {
        return null;
    }

    @Override
    public void exclusao(Long id) {
        repositorio.deleteById(id);
    }
}
