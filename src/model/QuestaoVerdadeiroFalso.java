package model;

public class QuestaoVerdadeiroFalso extends Questao {
    private boolean gabaritoCorreto;

    public QuestaoVerdadeiroFalso(Integer id, String enunciado, int pontosBase, boolean gabaritoCorreto) {
        super(id, enunciado, pontosBase);
        this.gabaritoCorreto = gabaritoCorreto;
    }

    @Override
    public boolean verificarResposta(String respostaUsuario) {
        if (respostaUsuario == null) return false;
        boolean respostaBool = respostaUsuario.trim().equalsIgnoreCase("V")
                            || respostaUsuario.trim().equalsIgnoreCase("TRUE");
        return respostaBool == this.gabaritoCorreto;
    }

    @Override
    public int calcularPontuacao() {
        return getPontosBase();
    }

    public boolean isGabaritoCorreto() {
        return gabaritoCorreto;
    }

    public void setGabaritoCorreto(boolean gabaritoCorreto) {
        this.gabaritoCorreto = gabaritoCorreto;
    }
}
