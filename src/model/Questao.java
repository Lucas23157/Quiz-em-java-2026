package model;

import exception.RegraQuizException;

public abstract class Questao implements Avaliavel {
    private final Integer id;
    private String enunciado;
    private int pontosBase;

    public Questao(Integer id, String enunciado, int pontosBase) {
        this.id = id;
        setEnunciado(enunciado);
        setPontosBase(pontosBase);
    }

    public abstract boolean verificarResposta(String respostaUsuario);
    public abstract int calcularPontuacao();

    @Override
    public int obterPontos() {
        return calcularPontuacao();
    }

    @Override
    public String gerarResumoAvaliacao() {
        return "Questão: " + enunciado + " | Valor: " + calcularPontuacao() + " pts";
    }

    public Integer getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        if (enunciado == null || enunciado.trim().length() < 5) {
            throw new RegraQuizException("O enunciado da questão deve ter pelo menos 5 caracteres.");
        }
        this.enunciado = enunciado.trim();
    }

    public int getPontosBase() {
        return pontosBase;
    }

    public void setPontosBase(int pontosBase) {
        if (pontosBase <= 0) {
            throw new RegraQuizException("Os pontos base da questão devem ser maiores que zero.");
        }
        this.pontosBase = pontosBase;
    }
}
