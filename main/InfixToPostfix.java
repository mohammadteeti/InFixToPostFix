package main;
import java.util.function.Function;


/** Concrete Class to evaluate arithmetic expression
 * @author Mohamamd j Teeti
 * @version 1.1
 * 
 * The class contains series of methods which work corporatively 
 * to convert any Infix arithmetic expression to a Postfix expression
 * Linked-Stack is used as the ADT and the algorithm solves for 
 * one digit operands , 4 arithmetic operations [+,-,*,/] and round brackets ()
 * 
 * 
 **/
public class InfixToPostfix{

    /**
     * Main Method for Use Case Testing 
     * @param args command line atguments entered by user
     */
    public static void main(String[] args) {
        
        if (args.length==0){
            System.out.println("No Input");
            return ;
        }

        String expression = convertExpression(args[0]);
        System.out.println(expression);
        System.out.println("Result "+ calculate(expression));
    }

    /**
     * Converts Infix to Postfix 
     * This Method calls 
     * @see #ChkStable(char )  
     * to check 
     * for round brackets balancing befor 
     * continuing the evaluation
     * @param expression : Infix Arithmetic Expression
     * @return The Postfix Experssion as String
     */
    public static String convertExpression(String expression){

        //extract brackets only
        String brackets="";
        boolean hasBrackets=false;
        for (char c :expression.toCharArray()){
            if (c=='(' || c==')'){
                hasBrackets=true;
                brackets+=c;
            }
        }
        
        if(hasBrackets){
            if(!ChkStable(brackets.toCharArray())){
                return "UnBalanced Brackets!";
            }
        }

        // the code assumes integers of only one digit
        LinkedStack<Character> s = new LinkedStack();
        char [] exp= expression.toCharArray();
        String str = "";

        for (int i = 0 ;i<exp.length;i++){
            if (isNumber(exp[i]))
                str+=exp[i];
            else if(isOperation(exp[i])){
                if (s.isEmpty())
                    s.add(exp[i]);

                else if (isOpen(s.getTop().getValue())){
                    s.add(exp[i]);
                }
                else
                    if(isPriorOperation(exp[i], s.getTop().getValue()))
                            s.add(exp[i]);
                    else{
                            str+=s.pop();
                            s.add(exp[i]);
                    }
            }
            else if (isOpen(exp[i])){
                s.add(exp[i]);
            }
            else if (isClose(exp[i])){
                while (!isOpen(s.getTop().getValue())){
                    str+=s.pop(); //add all ops between brackets to the expression
                }
                s.pop(); // remove open bracket
            }
        }
        while(!s.isEmpty())
            str+=s.pop();
        return str;
    }

    /**
     * checks a number or not
     * @param n : charachter from the expression
     * @return : True if the character is a number from 1 to 9 ,False otherwise
     */
    public static boolean isNumber(char n){
        return ((int)(n) >= 48 && (int)(n)<=57);
    }

    /**
     * checks if character is an operation
     * @param n : character from the expression
     * @return  : True if the character is an Operation from [+,-,*,/] ,False otherwise
     */
    public static boolean isOperation(char n){

        char [] arr =  new char[] {'+','-','*','/'};
        Function<Character,Boolean> equal =(c)->{
            return c==n;};

        for ( char c :arr)
            if(equal.apply(c)){
                return true;  
            }
        return false;

    }

    /**
     * The Method compares two arithmetic operations in terms
     * of priority ,Multiplication and Division  have priority 
     * over Summation and Subtraction
     * 
     * @param op : the operation in the Infix Expression String 
     * @param stackOp : the operation in the stack 
     * @return : True if op is prior that stackOp ,False otherwise
     */
    public static boolean isPriorOperation(char op,char stackOp){

        return (stackOp=='+' || stackOp=='-') && (op=='*' || op=='/');
    }

    /**
     * Chacks that balance of round bracket stream
     * @param b : bracket charaacter stream 
     * @return True if each open has it's closing bracket ,False otherwise 
     */
    public static boolean ChkStable (char [] b){

 
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

    /**
     * Chekcs what bracket is close
     * @param bracket : a character either '(' or ')'
     * @return True if the bracket is ) closing ,False otherwise
     */
    public static boolean isClose(char bracket){return bracket==')';}
    /**
     * Cheks what bracket is open
     * @param bracket : a character either '(' or ')'
     * @return True if the bracket is ( opening ,False otherwise
     */
    public static boolean isOpen(char bracket){return bracket=='(';}

    /**
     * Main calculation method  calls 
     * @see #applyOperation(char, double, double)
     * @param expression Postfix expression after conversion
     * @return the value of the calculation of the whole Postfix expression as Double
     */
    public static double calculate (String expression){
        LinkedStack<String> s = new LinkedStack<>();
        double op1,op2,res;

        char exp [] = expression.toCharArray();
        for (int i = 0 ;i<exp.length;i++){

            if (isNumber(exp[i])){

                s.add(exp[i]+"");

            }else if (isOperation(exp[i])){
                    op2=Double.valueOf(s.pop()); //pop op2 before op1 as stack implies 
                    op1=Double.valueOf(s.pop()); //op1 comes before in the  evaluation
                    res=applyOperation(exp[i], op1, op2);

                    if (res==Double.MIN_VALUE)
                        throw new ArithmeticException("Division By zero");
                    else
                        s.add(res+"");


            }

    }

return Double.valueOf(s.pop());
}

/**
 * make calculations
 * @param  opration : [+,-,*,/] character
 * @param  op1 : left-side operand
 * @param  op2 : right-side operand
 * 
 * @return double value from the arithmetic evaluation of the operation on op1 and op2
 */
static double applyOperation( char operation,double op1,double op2){

    switch(operation){

        case '+':
            return op1 + op2;
        case '-':
            return op1 - op2;
        case '*':
            return op1 * op2;
        case '/':
            if(op2 != 0 )
                return op1/op2;
            else
                return Double.MIN_VALUE;//instead of error
    }
    return 0.0;
}
}

