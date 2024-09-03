package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExcluirUsuarioTest {

    private RepositorioDeUsuario repositorioDeUsuarioMock;
    private ExcluirUsuario excluirUsuario;
    private UsuarioEntityMapper mapper;

    @BeforeEach
    void setUp() {
        // Criação do mock do repositório
        repositorioDeUsuarioMock = Mockito.mock(RepositorioDeUsuario.class);
        mapper = Mockito.mock(UsuarioEntityMapper.class);

        // Instanciação do caso de uso com o mock
        excluirUsuario = new ExcluirUsuario(repositorioDeUsuarioMock);

    }

    @Test
    void deveChamarExclusaoDoRepositorioComIdCorreto() {
        // Criação do usuário esperado
        var usuario = new Usuario(
                "123.456.787-21",
                "Pedro",
                LocalDate.of(2003, 6, 14),
                "teste@exemplo.com");

        // Configuração do mock para retornar o usuário ao buscar pelo ID 1L
        when(repositorioDeUsuarioMock.encontrarPorId(1L)).thenReturn(usuario);

        // Verifica que o usuário encontrado é o esperado
        assertEquals(
                usuario,
                repositorioDeUsuarioMock.encontrarPorId(1L)
        );

        // Chama o método de exclusão
        repositorioDeUsuarioMock.exclusao(1L);

        // Configura o mock para retornar null após a exclusão, simulando que o usuário foi excluído
        when(repositorioDeUsuarioMock.encontrarPorId(1L)).thenReturn(null);

        // Verifica que o usuário não é encontrado após a exclusão
        assertNull(repositorioDeUsuarioMock.encontrarPorId(1L));
    }
}