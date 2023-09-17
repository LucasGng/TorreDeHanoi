public class Stack {
    private Node top;
    public Stack(){

    }
    public void push(int number){
        Node node = new Node(number);
        Node temp;
        if(top == null) {
            top = node;
        }
        else{
            temp = top;
            top = node;
            top.setNext(temp);
        }
    }

    public void pull(){
        Node temp;
        if(top == null){
            System.out.println("Pilha Vazia! Impossivel remover!!");
        }
        else{
            temp = top;
            top = top.getNext();
            temp = null;
        }
    }

    public void show(){

        if(top == null){
            System.out.println("Pilha vazia");
        }
        else {
            Node node;
            node = top;
            System.out.print(node.getData()+" ");
            while (node.getNext() != null ) {
                node = node.getNext();
                System.out.print(node.getData()+" ");
            }
        }
    }
}
