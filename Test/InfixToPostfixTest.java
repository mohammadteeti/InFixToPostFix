package Test;

import main.InfixToPostfix;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class InfixToPostfixTest {
    
    @Test
    public void isNumberTest(){

        //test for numbers
        for (int i = 48 ;i<58;i++){
            System.out.println("Test for Numbers");
            System.out.println((char)i);
            assertEquals(true,InfixToPostfix.isNumber((char)(i)));
        }

        //test for non-numbers any range out of [48-57]
        for (int i = 0;i<47;i++){
            System.out.println("Test for Non-Numbers");
            System.out.println((char)i);
            assertEquals(false,InfixToPostfix.isNumber((char)(i)));
        }
    }

    @Test
    public void isOperationTest(){
        //test for operations
        char [] arr= new char[] {'+','-','*','/'};

        for (char c :arr)
            assertEquals(true, InfixToPostfix.isOperation(c));


        //test for non-operations
        arr= new char[] {'2','#','^',','};
        for (char c :arr)
            assertEquals(false, InfixToPostfix.isOperation(c));
    }

    @Test
    public void isPriorOperationTest(){

        assertEquals(true, InfixToPostfix
        .isPriorOperation('*','+'));

        assertEquals(false, InfixToPostfix
        .isPriorOperation('*','/'));

        assertEquals(false, InfixToPostfix
        .isPriorOperation('-','+'));
        
        assertEquals(true, InfixToPostfix
        .isPriorOperation('/','-'));


    }
}
