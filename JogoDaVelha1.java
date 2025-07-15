import java.util.Scanner;

public class JogoDaVelha1 {

    public static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static char jogadorAtual = 'X';
    public static boolean jogoTerminou = false;
     public static Scanner entrada = new Scanner(System.in);

    public static void imprimirTabuleiro() {

        limparTela();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print("\t" + tabuleiro[i][j]);
                if (j < 2) System.out.print("\t|");
            }

            System.out.println();
            if (i < 2) System.out.println("        ----------------------------------------");
        }
    }
    
    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela");
        }
    }

    public static boolean posicaoValida(int posicao) {
        return posicao >= 1 && posicao <= 9 && tabuleiro[(posicao - 1) / 3][(posicao - 1) % 3] == ' ';
    }

    public static boolean verificaVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador)
                return true;
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)
                return true;
        }
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador)
            return true;
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)
            return true;
        return false;
    }

    public static boolean verificaEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void switchPlayer() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {

        System.out.println("JOGO DA VELHA");

        while (!jogoTerminou) {

            imprimirTabuleiro();

            System.out.println("Jogador " + jogadorAtual + ", escolha sua posição (1-9):");
            int posicao = entrada.nextInt();

            if (posicaoValida(posicao)) {

                int linha = (posicao - 1) / 3;
                int coluna = (posicao - 1) % 3;
                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificaVitoria(jogadorAtual)) {

                    imprimirTabuleiro();

                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoTerminou = true;

                } else if (verificaEmpate()) {

                    imprimirTabuleiro();

                    System.out.println("Empate!");
                    jogoTerminou = true;

                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }
        }
        
    }
}









































