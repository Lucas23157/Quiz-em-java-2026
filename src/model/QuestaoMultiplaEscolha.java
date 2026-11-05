package model;

import exception.RegraQuizException;

public class QuestaoMultiplaEscolha extends Questao {
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private char gabarito;
    private int nivelDificuldade;

    public QuestaoMultiplaEscolha(Integer id, String enunciado, int pontosBase,
                                  String alternativaA, String alternativaB, String alternativaC,
                                  char gabarito, int nivelDificuldade) {
        super(id, enunciado, pontosBase);
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        setGabarito(gabarito);
        setNivelDificuldade(nivelDificuldade);
    }

    public void setGabarito(char gabarito) {
        char upper = Character.toUpperCase(gabarito);
        if (upper != 'A' && upper != 'B' && upper != 'C') {
            throw new RegraQuizException("O gabarito deve ser 'A', 'B' ou 'C'.");
        }
        this.gabarito = upper;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        if (nivelDificuldade < 1 || nivelDificuldade > 3) {
            throw new RegraQuizException("O nível de dificuldade deve ser entre 1 e 3.");
        }
        this.nivelDificuldade = nivelDificuldade;
    }

    @Override
    public boolean verificarResposta(String respostaUsuario) {
        if (respostaUsuario == null || respostaUsuario.isBlank()) return false;
        return Character.toUpperCase(respostaUsuario.trim().charAt(0)) == this.gabarito;
    }

    @Override
    public int calcularPontuacao() {
        return getPontosBase() * nivelDificuldade;
    }

    public String getAlternativaA() { return alternativaA; }
    public String getAlternativaB() { return alternativaB; }
    public String getAlternativaC() { return alternativaC; }
    public char getGabarito() { return gabarito; }
    public int getNivelDificuldade() { return nivelDificuldade; }
}
