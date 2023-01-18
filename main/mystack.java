package main;
import static java.lang.System.out;

import java.lang.reflect.Array;
import java.util.Arrays;
public class mystack {
    
    public static void main(String[] args) {
        // Stack s = new Stack();

        // out.println("Add : "+s.add(5));
        // out.println("Add : "+s.add(7));
        // out.println("Add : "+s.add(3));
        // out.println("Add : "+s.add(52));

        // s.print();
        // out.println("size = "+s.getSize());
        // //remove elements 
        // out.println( "Remove : "+ s.remove());
        // out.println( "Remove : "+ s.remove());
        // s.print();

        // out.println("Add : "+s.add(5));
        // s.print();

        Stack2 s = new Stack2(5);

        out.println("add : "+s.add(23));
        out.println("add : "+s.add(15));
        out.println("add : "+s.add(10));
        out.println("add : "+s.add(12));
        out.println("add : "+s.add(11));

        s.print();

        out.println("Remove : " + s.pop());
        s.print();
        out.println("Remove : " + s.pop());
        s.print();
        out.println("add: " + s.add(17));
        out.println("add: " + s.add(50));
        s.print();


        

    }
}

class Stack {

    protected int size;

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    protected int [] arr ;

    public Stack(){
        this.size=0;

    }
    public int  add (int x ){
        if (size==0){
            //first number
            arr=new int [1];// one element [] -> arr[0] 
            out.print("add first number  ");       
        }
        else {
            int [] newArr=new int[size+1];
            for (int i = 0 ;i<size;i++)
                    newArr[i+1]=arr[i];
                
            arr=newArr;
            
        }
        arr[0]=x;
        size++;
        return arr[0];
    }

    public int remove(){
        if (size==0 )
            return -1;
        
        int num=arr[0];
        
        int [] newArr = new int [size-1];
        for (int i = 0;i<size-1;i++)
            newArr[i]=arr[i+1];
        
        arr=newArr;
        size--;
        
        return num;
    }

    public void  print(){

        for (int i=0;i<size;i++)
            out.print(arr[i]+ " ");
        out.println();   
    }
    
}

class Stack2{

    int [] arr ;
    int top=-1;
    int size=5;
    public Stack2(int size){
        if (size>0)
            arr=new int[size];
        else    
            arr=new int[5];//default of 5 
    }

    int add (int x){

        if(top<size-1)
            arr[++top]=x;
        return arr[top];

    }

    int pop (){
        if (top==-1)
            return -1;
         int num=arr[top];
         arr[top--]=0;
         return num;

    }

    void print(){
            Arrays.stream(arr).forEach(e->System.out.println(e));
     }

}
