package model;

import exception.RegraQuizException;

public class Jogador {
    private final Integer id;
    private String nome;
    private String apelido;

    public Jogador(Integer id, String nome, String apelido) {
        this.id = id;
        setNome(nome);
        setApelido(apelido);
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getApelido() { return apelido; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new RegraQuizException("O nome do jogador deve ter no mínimo 3 caracteres.");
        }
        this.nome = nome.trim();
    }

    public void setApelido(String apelido) {
        if (apelido == null || apelido.trim().length() < 2) {
            throw new RegraQuizException("O apelido (nickname) deve ter no mínimo 2 caracteres.");
        }
        this.apelido = apelido.trim();
    }

    @Override
    public String toString() {
        return apelido + " (" + nome + ")";
    }
}
