package main;

public class LinkedStack<T>{
    
    class Node {
        T  value ;
        Node next;

        public T getValue() {return value;}
        public void setValue(T value) {this.value = value;} 

        public Node getNext() {return next;}
        public void setNext(Node next) {this.next = next;}

    }

    Node top ;

    public Node getTop() {
        return top;
    }


    public LinkedStack(){
        top=null;
    }

    
    public Node add (T val){

        Node newNode=new Node() ;
        newNode.setValue(val);
        newNode.setNext(top);

        top=newNode;


        
        return top;
    }

    public T pop(){

        if (top==null){
            System.out.println("Empty Stack");
            return null;
        }

        Node n = top;
        top=top.getNext();
        return n.getValue();
    }

    public void print(){

        Node n =top ;
        while(n!=null){
            System.out.println(n.getValue());
            n=n.getNext();

        }
    }

    public boolean isEmpty (){
        return top==null;
    }


}


