import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Digite o número de discos da torre de hanói: ");
       int size = sc.nextInt();
       System.out.println("O jogo deve ser realizado de forma crescente ou decrescente? 1.(cresc) 2.(decresc)");
       int gameType = sc.nextInt();
       TorreHanoi torre = new TorreHanoi(size,gameType);

       System.out.println("O jogo torre de hanói começou com "+size+ " discos");

       torre.printTorre();

       while(!torre.isWinCond()){
           System.out.println("------- Menu operacoes ----------");
           System.out.println("0. Sair do jogo");
           System.out.println("1. Fazer um movimento");
           System.out.println("2. Mostrar torre");
           System.out.println("3. Resolver automaticamente");
           System.out.println("Digite a operação a ser realizada");
           int op = sc.nextInt();
           switch(op){
               case 1:
                   torre.fazerMovimento();
                   torre.count();
                   torre.isSorted(gameType,torre.getStack1(),size);
                   torre.isSorted(gameType,torre.getStack2(),size);
                   torre.isSorted(gameType,torre.getStack3(),size);

                   break;
               case 2:
                   torre.printTorre();
                   break;
               case 3:
                   if(gameType == 2){
                       torre.resolverAutomaticamenteDecresc();
                   }else if(gameType == 1){
                       torre.resolverAutomaticamenteCresc();
                   }
           }
       }
    }
}

