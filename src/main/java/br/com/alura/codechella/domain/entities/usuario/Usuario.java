package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;
import br.com.alura.codechella.infra.controller.UsuarioDto;

import java.time.LocalDate;

public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    private Endereco endereco;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}"))
            throw new IllegalArgumentException("Cpf no padrão incorreto!");
//        if (email == null || !email.matches("(?i)[a-z0-9.]+@[a-z0-9]+\\\\.[a-z]+(\\\\.[a-z]+)?"))
//            throw new IllegalArgumentException("Email inválido!");
        this.cpf = cpf;
    }

//    public Usuario(Builder builder) {
//        this.nome = builder.nome;
//        this.cpf = builder.cpf;
//        this.email = builder.email;
//    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void atualizar(UsuarioDto dto){
        if (dto.cpf() != null)
            this.cpf = dto.cpf();
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.email() != null)
            this.email = dto.email();
    }

//    public static class Builder {
//        private String cpf;
//        private String nome;
//        private LocalDate nascimento;
//        private String email;
//
//        private Endereco endereco;
//
//        public Endereco getEndereco() {
//            return endereco;
//        }
//
//        public Builder nome(String nome) {
//            this.nome = nome;
//            return this;
//        }
//
//        public Builder cpf(String cpf) {
//            this.cpf = cpf;
//            return this;
//        }
//
//        public Builder nascimento(LocalDate nascimento) {
//            this.nascimento = nascimento;
//            return this;
//        }
//
//        public Usuario build() {
//            return new Usuario(this);
//        }
//    }

}