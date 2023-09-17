import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número de discos da torre de hanói: ");
       int size = sc.nextInt();
       TorreHanoi torre = new TorreHanoi(size);

       System.out.println("O jogo torre de hanói começou com "+size+ " discos");

       while(torre.isWinCond() == false){
           System.out.println("------- Menu operacoes ----------");
           System.out.println("0. Sair do jogo");
           System.out.println("1. Fazer um movimento");
           System.out.println("2. Mostrar torre");
           System.out.println("Digite a operação a ser realizada");
           int op = sc.nextInt();
           switch(op){
               case 1:
                   torre.fazerMovimento();
               case 2:
           }
           break;
       }
    }
}

