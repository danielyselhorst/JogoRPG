import java.util.Scanner;
public class jogoAdivinhacao{

public static void main(String[] args) {

 Scanner entrada = new Scanner(System.in);
 int numero = (int)(Math.random() * 101);
 int numeroDigitado = 0;
 int cont = 0;

System.out.println("Numero gerado: "+numero);

do{

 System.out.println("Bem vindo ao jogo!!!");
 System.out.println("Advinhe o numero que seja de 0 - 100: ");
 numeroDigitado = entrada.nextInt();

if(numeroDigitado > numero){
    System.out.println("numerero gerado e menor!!");
}else if(numero < numero){
    System.out.println("Numero geredo e maior!!");
}else{
    System.out.println("Voce acertou");
}
cont++;

}while(numeroDigitado != numero);
System.out.println("Numero de tentativas: "+cont);
}
}
