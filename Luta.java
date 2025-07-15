public class Luta {
    // Atributos
    public String nome;
    public String classe;
    public int nivel = 1;
    public int vida = 100;
    public int mana;
    public int forca;

    // Método genérico de ataque (colocado com corpo vazio para evitar erro de compilação)
    public void atacar() {
        System.out.println(nome + " atacou!");
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nome + " recebeu " + dano + " de dano. Vida agora: " + vida);
    }

    public void usarHabilidadesEspecial() {
        System.out.println(nome + " usou habilidade especial!");
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        if (mana > 0) System.out.println("Mana: " + mana);
        System.out.println("===================");
    }

    public void subirNivel() {
        nivel += 1;
        vida += 10;
        if (vida > 100) vida = 100;
        forca += 1;
        if (mana > 0) {
            mana += 10;
            if (mana > 100) mana = 100;
        }
        System.out.println(nome + " subiu ao nível " + nivel);
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + nome + " | Classe: " + classe + " | Nivel: " + nivel +
                " | Vida: " + vida + " | Forca: " + forca);
        if (mana > 0) {
            System.out.println("| Mana: " + mana);
        }
    }
     public void desenharPersonagem(int personagem) {
        System.out.println(" personagem " + personagem + ":");
        switch(personagem) {
            case 1: 
            System.out.println("   ( x_x )");
            System.out.println("   /| _ |\\");
            System.out.println("    |   | ");
            System.out.println("   /     \\");
            System.out.println();
                break;
            case 2:
            System.out.println("     /\\ ");
            System.out.println("    /__\\ ");
            System.out.println("   ( o_o )");
            System.out.println("   /| _ |\\ ");
            System.out.println("    |   | ");
            System.out.println("   /     \\");
            System.out.println();
                break;
            default:
                System.out.println("Personagem desconhecido.");
        }
}
}