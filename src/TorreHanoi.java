import java.util.Scanner;

public class TorreHanoi {
    private Stack stack1;
    private Stack stack2;
    private Stack stack3;

    private boolean winCond = false;

    public TorreHanoi(int size){
        stack1 = new Stack();
        stack2 = new Stack();
        stack3 = new Stack();

        for(int i=size;i>0;i--){
            stack1.push(i);
            stack2.push(-1);
            stack3.push(-1);
        }
    }

    public boolean isWinCond() {
        return winCond;
    }

    public void printTorre(){
        System.out.print("Torre 1: ");
        stack1.show();
        System.out.println("\n");
        System.out.print("Torre 2: ");
        stack2.show();
        System.out.println("\n");
        System.out.print("Torre 3: ");
        stack3.show();
        System.out.println("\n");
    }
    public void fazerMovimento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Escolha uma pilha para fazer um movimento -----");
        printTorre();
        System.out.println("Digite a pilha que você quer começar o movimento");
        int op = sc.nextInt();
        switch(op){
            case 1:
                System.out.println("Digite a pilha que você quer terminar o movimento");
            case 2:
                System.out.println("Digite a pilha que você quer terminar o movimento");
                
        }
    }


}
