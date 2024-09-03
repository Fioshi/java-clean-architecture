package br.com.alura.codechella.config;

import br.com.alura.codechella.application.usecases.AtualizarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.controller.UsuarioDto;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuarioBean(RepositorioDeUsuarioJpa repositorioDeUsuarioJpa) {
        return new CriarUsuario(repositorioDeUsuarioJpa);
    }

    @Bean
    ListarUsuarios listarUsuarios (RepositorioDeUsuarioJpa repository){
        return new ListarUsuarios(repository);
    }

    @Bean
    RepositorioDeUsuarioJpa repositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioJpa(repository, mapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper () {
        return new UsuarioEntityMapper();
    }

    @Bean
    AtualizarUsuario atualizarUsuario(RepositorioDeUsuarioJpa repository) {
        return new AtualizarUsuario(repository);
    }

    @Bean
    ExcluirUsuario excluirUsuario (RepositorioDeUsuarioJpa repository){
        return new ExcluirUsuario(repository);
    }
}
