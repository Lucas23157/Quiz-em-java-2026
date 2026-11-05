package model;

import exception.RegraQuizException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Avaliavel {
    private final Integer id;
    private final LocalDateTime dataHora;
    private Jogador jogador;
    private List<Questao> questoes;
    private int pontuacaoObtida;

    public Partida(Integer id, Jogador jogador) {
        if (jogador == null) {
            throw new RegraQuizException("A partida precisa de um jogador válido.");
        }
        this.id = id;
        this.jogador = jogador;
        this.dataHora = LocalDateTime.now();
        this.questoes = new ArrayList<>();
        this.pontuacaoObtida = 0;
    }

    public void adicionarQuestao(Questao questao) {
        if (questao == null) {
            throw new RegraQuizException("Não é possível adicionar uma questão nula.");
        }
        this.questoes.add(questao);
    }

    public int calcularPontuacaoMaximaPossivel() {
        int total = 0;
        for (Questao q : questoes) {
            total += q.calcularPontuacao();
        }
        return total;
    }

    public void registrarPontos(int pontos) {
        if (pontos < 0) {
            throw new RegraQuizException("A pontuação registrada não pode ser negativa.");
        }
        this.pontuacaoObtida += pontos;
    }

    @Override
    public int obterPontos() {
        return this.pontuacaoObtida;
    }

    @Override
    public String gerarResumoAvaliacao() {
        return "Jogador: " + jogador.getApelido() +
               " | Pontos: " + pontuacaoObtida + "/" + calcularPontuacaoMaximaPossivel();
    }

    public Integer getId() { return id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Jogador getJogador() { return jogador; }
    public List<Questao> getQuestoes() { return questoes; }
}
