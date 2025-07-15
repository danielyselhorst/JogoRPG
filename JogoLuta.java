import java.util.Scanner;

public class JogoLuta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean turnoJogador1 = true;

        Luta jogador1 = new Luta();
        System.out.println("Jogador 1, quem você deseja ser, zumbi ou mago?");
        jogador1.classe = scanner.nextLine();
        System.out.println("Digite o nome do seu personagem:");
        jogador1.nome = scanner.nextLine();
        if (jogador1.classe.equalsIgnoreCase("zumbi")) {
            jogador1.forca = 15;
            jogador1.mana = 0;
        } else if (jogador1.classe.equalsIgnoreCase("mago")) {
            jogador1.forca = 10;
            jogador1.mana = 100;
        } else {
            System.out.println("Classe inválida. Encerrando o jogo.");
            scanner.close();
            return;
        }

        Luta jogador2 = new Luta();
        System.out.println("Jogador 2, quem voce deseja ser, zumbi ou mago?");
        jogador2.classe = scanner.nextLine();
        System.out.println("Digite o nome do seu personagem:");
        jogador2.nome = scanner.nextLine();
        if (jogador2.classe.equalsIgnoreCase("zumbi")) {
            jogador2.forca = 15;
            jogador2.mana = 0;
        } else if (jogador2.classe.equalsIgnoreCase("mago")) {
            jogador2.forca = 10;
            jogador2.mana = 100;
        } else {
            System.out.println("Classe inválida. Encerrando o jogo.");
            scanner.close();
            return;
        }

        int opcao;

        while (jogador1.vida > 0 && jogador2.vida > 0) {
            Luta atacante;
            Luta defensor;

            if (turnoJogador1) {
                atacante = jogador1;
                defensor = jogador2;
                System.out.println("\nTurno de " + atacante.nome);
            } else {
                atacante = jogador2;
                defensor = jogador1;
                System.out.println("\nTurno de " + atacante.nome);
            }

            System.out.println("====== MENU ======");
            System.out.println("1 - Golpe com espada");
            System.out.println("2 - Feitiço jogado");
            System.out.println("3 - Mordida carnivora");
            System.out.println("4 - Chutes");
            System.out.print("Escolha seu ataque: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um numero válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();  

            int dano = 0;
            switch (opcao) {
                case 1:
                    dano = atacante.forca + 30;
                    System.out.println(atacante.nome + " usou Golpe com espada causando " + dano + " de dano");
                    atacante.desenharPersonagem(2);
                    break;
                case 2:
                    dano = atacante.forca + 8;
                    System.out.println(atacante.nome + " lançou Feitico causando " + dano + " de dano");
                    atacante.desenharPersonagem(2);
                    break;
                case 3:
                    dano = atacante.forca + 10;
                    System.out.println(atacante.nome + " usou Mordida carnivora causando " + dano + " de dano");
                    atacante.desenharPersonagem(1);
                    break;
                case 4:
                    dano = atacante.forca + 5;
                    System.out.println(atacante.nome + " usou Chutes causando " + dano + " de dano");
                    atacante.desenharPersonagem(1);
                    break;
                default:
                    System.out.println("Ataque inválido! Perdeu a vez.");
                    dano = 0;
                    break;
            }

            defensor.receberDano(dano);
            defensor.mostrarStatus();

            turnoJogador1 = !turnoJogador1;
        }

        System.out.println("Jogo encerrado");
        scanner.close();
    }
}
