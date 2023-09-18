
import java.util.Scanner;
import java.util.Random;
public class TorreHanoi {
    private Stack stack1;
    private Stack stack2;
    private Stack stack3;

    private int gameMode;

    private int size;

    private int count;

    private boolean winCond = false;

    public TorreHanoi(int size,int gameMode){
        stack1 = new Stack();
        stack2 = new Stack();
        stack3 = new Stack();
        this.gameMode = gameMode;
        this.size = size;


        Random gerador = new Random();

        for(int i=size;i>0;i--){
            stack1.push(gerador.nextInt(100));
        }
    }

    public void count(){
        count++;
    }

    public boolean isWinCond() {
        return winCond;
    }

    public void setWinCond(boolean bool){this.winCond = bool; }

    public Stack getStack1() {
        return stack1;
    }
    public Stack getStack2() {
        return stack2;
    }
    public Stack getStack3(){
        return stack3;
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
        System.out.println("Digite a pilha que você quer terminar o movimento");
        int op2 = sc.nextInt();

        if(op == op2){
            System.out.println("A Pilha que você quer mover não pode ser a mesma que o destino");
            return;
        }

        switch(op){
            case 1:
                if(op2 == 2){
                    stack2.push(stack1.getTopData());
                    stack1.pull();
                    winCond = isSorted( gameMode,stack2, size);
                    break;
                }
                else if(op2 == 3){
                    stack3.push(stack1.getTopData());
                    stack1.pull();
                    winCond = isSorted( gameMode,stack3, size);
                    break;
                }
                break;
            case 2:
                if(op2==1){
                    stack1.push(stack2.getTopData());
                    stack2.pull();
                    winCond = isSorted( gameMode,stack1, size);
                    break;
                }
                else if(op2==3){
                    stack3.push(stack2.getTopData());
                    stack2.pull();
                    winCond = isSorted( gameMode,stack3, size);
                    break;
                }
                break;

            case 3:
                if(op2 == 1){
                    stack1.push(stack3.getTopData());
                    stack3.pull();
                    break;
                }
                else if(op2 == 2){
                    stack2.push(stack3.getTopData());
                    stack3.pull();
                    break;
                }
                break;

        }

        }
    public void mover(int op,int op2){
        switch(op){
            case 1:
                if(op2 == 2){
                    stack2.push(stack1.getTopData());
                    stack1.pull();


                    break;
                }
                else if(op2 == 3){
                    stack3.push(stack1.getTopData());
                    stack1.pull();


                    break;
                }
                break;
            case 2:
                if(op2==1){
                    stack1.push(stack2.getTopData());
                    stack2.pull();

                    break;
                }
                else if(op2==3){
                    stack3.push(stack2.getTopData());
                    stack2.pull();

                    break;
                }
                break;

            case 3:
                if(op2 == 1){
                    stack1.push(stack3.getTopData());
                    stack3.pull();

                    break;
                }
                else if(op2 == 2){
                    stack2.push(stack3.getTopData());
                    stack3.pull();
                    break;
                }
                break;
        }
    }

    public void resolverAutomaticamenteCresc(){
        for(int i =0;i<size;i++){
            while(stack1.getTop() != null){
                if(stack2.getTop() == null){
                    System.out.println("Movimento numero "+this.count);
                    mover(1,2);
                    count();
                    printTorre();
                }else if(stack1.getTopData() > stack2.getTopData()){
                    System.out.println("Movimento numero "+this.count);
                    mover(1,2);
                    count();
                    printTorre();
                }else{
                    System.out.println("Movimento numero "+this.count);
                    mover(1,3);
                    count();
                    printTorre();
                }
            }
            while(stack2.getTop() != null){
                System.out.println("Movimento numero "+this.count);
                mover(2,1);
                count();
                printTorre();
            }
            while(stack3.getTop() != null){
                System.out.println("Movimento numero "+this.count);
                mover(3,1);
                count();
                printTorre();
            }
        }


        if(isSorted(gameMode,stack1, size)){
            System.out.println("Jogo finalizado em forma crescente");
        }

    }
    public void resolverAutomaticamenteDecresc(){
        for(int i =0;i<size;i++){
            while(stack1.getTop() != null){
                if(stack2.getTop() == null){
                    System.out.println("Movimento numero "+this.count);
                    mover(1,2);
                    count();
                    printTorre();
                }else if(stack1.getTopData() < stack2.getTopData()){
                    System.out.println("Movimento numero "+this.count);
                    mover(1,2);
                    count();
                    printTorre();
                }else{
                    System.out.println("Movimento numero "+this.count);
                    mover(1,3);
                    count();
                    printTorre();
                }
            }
            while(stack2.getTop() != null){
                System.out.println("Movimento numero "+this.count);
                mover(2,1);
                count();
                printTorre();
            }
            while(stack3.getTop() != null){
                System.out.println("Movimento numero "+this.count);
                mover(3,1);
                count();
                printTorre();
            }
        }


        if(isSorted(gameMode,stack1, size)){
            System.out.println("Jogo finalizado em forma decrescente");
        }

    }

    public boolean isSorted(int mode, Stack stack, int size){
        Stack pilha = new Stack();
        switch(mode){
            case 1:
                pilha.push(stack.pull());
                int count = 0;
                while(stack.getTop() != null && count != size){
                    if(pilha.getTopData() >= stack.getTopData()){
                        pilha.push(stack.pull());
                        count++;
                    }
                    else{
                        return false;
                    }
                }
                break;
            case 2:
                pilha.push(stack.pull());
                int cont = 0;
                while(stack.getTop() != null && cont != size){
                    if(pilha.getTopData() <= stack.getTopData()){
                        pilha.push(stack.pull());
                        cont++;
                    }
                    else{
                        return false;
                    }
                }
                break;
        }
        while(pilha.getTop() != null){
            stack.push(pilha.pull());
        }
        return true;
    }


}
