package main;
public class LinkedStackTest{
    public static void main(String[] args) {
        
        

        if (args[0]==null || args[0]=="")
            return;
        
        char [] b = new char [args[0].length()];
        b=args[0].toCharArray();

        System.out.printf("Is %s Stable Pattern ? %s ",args[0],ChkStable(b));

        //LinkedStack s = new LinkedStack();
        // System.out.println("IsEmpty : "+ s.isEmpty());
        // s.add(50);
        // s.add(30);
        // s.add(70);

        // s.print();
        // System.out.println("\nIsEmpty : "+ s.isEmpty());
        // //pop values 
        // System.out.println("Pop : " + s.pop());
        // System.out.println("Pop : " + s.pop());
        // s.print();
        // System.out.println("Pop : " + s.pop());
        // s.print();
        // System.out.println("Pop : " + s.pop());
        // System.out.println("First Element of Stack is "+ (s.getTop()==null?"N/A":s.getTop().getValue()));
        // System.out.println("\nIsEmpty : "+ s.isEmpty());
        // //add again 
        // System.out.println("add : "+ s.add(110).getValue());
        // System.out.println("add : "+ s.add(120).getValue());
        // System.out.println("add : "+ s.add(90).getValue());
        // System.out.println("First Element of Stack is "+ (s.getTop()==null?"N/A":s.getTop().getValue()));
        // s.print();



        // //add again 
        // System.out.println("add : "+ s.add("Mohammad").getValue());
        // System.out.println("add : "+ s.add("Ahmad").getValue());
        // System.out.println("add : "+ s.add("Khalid").getValue());

        // System.out.println("First Element of Stack is "+ (s.getTop()==null?"N/A":s.getTop().getValue()));
        // s.print();
        // System.out.println("\nIsEmpty : "+ s.isEmpty());
        
    }    


static boolean ChkStable (char [] b){

    
    LinkedStack<Character> s = new LinkedStack<>();
    if (isClose(b[0]))
        return false;

    s.add(b[0]);
    for (int i = 1 ;i<b.length;i++){

        if (isClose(b[i])){
            if(s.isEmpty())
                return false;
            if (isOpen(s.getTop().getValue()))
                s.pop();
        }
        else
            s.add(b[i]);
    }

    return s.isEmpty();

}

static boolean isClose(char bracket){return bracket=='}';}
static boolean isOpen(char bracket){return bracket=='{';}

}
