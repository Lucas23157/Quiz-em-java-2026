# Quiz-em-java-2026
Projeto quiz em java do 4° semestre com Linguagem Orientada ao Objeto em Java

# Sistema de Quiz com Ranking - POO 2026

Projeto Integrador N2 de Programação Orientada a Objetos.

## Integrantes
* Bruno Salvador Dias
* Paulo Lucas

## Tecnologias e Configurações
* **Linguagem:** Java 17+
* **Interface Gráfica:** Java Swing
* **Banco de Dados:** PostgreSQL (via JDBC)
* **Repositório:** https://github.com/Lucas23157/Quiz-em-java-2026

## Como Executar
1. Execute o script `banco.sql` no seu servidor PostgreSQL.
2. Duplique o arquivo `config.exemplo.properties`, renomeie para `config.properties` e preencha com suas credenciais do banco.
3. Compile e execute a classe principal no pacote `app`.

## Diagrama de Classes (Domínio)

```mermaid
classDiagram
    class Avaliavel {
        <<interface>>
        +obterPontos() int
        +gerarResumoAvaliacao() String
    }

    class Questao {
        <<abstract>>
        -Integer id
        -String enunciado
        -int pontosBase
        +Questao(Integer id, String enunciado, int pontosBase)
        +verificarResposta(String resposta)* boolean
        +calcularPontuacao()* int
        +getId() Integer
        +getEnunciado() String
        +setEnunciado(String enunciado) void
        +getPontosBase() int
        +setPontosBase(int pontosBase) void
    }

    class QuestaoMultiplaEscolha {
        -String alternativaA
        -String alternativaB
        -String alternativaC
        -char gabarito
        -int nivelDificuldade
        +verificarResposta(String resposta) boolean
        +calcularPontuacao() int
    }

    class QuestaoVerdadeiroFalso {
        -boolean gabaritoCorreto
        +verificarResposta(String resposta) boolean
        +calcularPontuacao() int
    }

    class Jogador {
        -Integer id
        -String nome
        -String apelido
        +Jogador(Integer id, String nome, String apelido)
        +getId() Integer
        +getNome() String
        +setNome(String nome) void
        +getApelido() String
        +setApelido(String apelido) void
    }

    class Partida {
        -Integer id
        -LocalDateTime dataHora
        -Jogador jogador
        -List~Questao~ questoes
        -int pontuacaoObtida
        +adicionarQuestao(Questao q) void
        +calcularPontuacaoMaximaPossivel() int
        +registrarPontos(int pontos) void
        +obterPontos() int
        +gerarResumoAvaliacao() String
    }

    Avaliavel <|.. Questao
    Avaliavel <|.. Partida
    Questao <|-- QuestaoMultiplaEscolha
    Questao <|-- QuestaoVerdadeiroFalso
    Partida *-- "1" Jogador : composição
    Partida o-- "1..*" Questao : polimorfismo
```
