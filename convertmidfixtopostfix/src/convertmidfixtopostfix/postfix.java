/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertmidfixtopostfix;

/**
 *
 * @author Khesraw
 */
public class postfix 
{
    static boolean isOperand(char x)
    {
        if(x=='+' || x=='-' || x=='*' || x=='/')
        {
            return false;
        }else
        {
            return true;
        }
    }
    
    static int pre(char x)
    {
        if(x=='+' || x=='-')
        {
            return 1;
        }else if(x=='*' || x=='/')
        {
            return 2;
        }
        return 0;
    }
  
   public static int eval(char[] postfix)
   {
       Stack st = new Stack();
       int i=0;
       int x1,x2,r=0;
       for(i=0;postfix[i] != ' ';i++)
       {
           if(isOperand(postfix[i]))
           {
               st.push(postfix[i]-'0');
           }else
           {
               x2=st.pop();
               x1=st.pop();
               switch(postfix[i])
               {
                   case '+':r=x1+x2;
                   break;
                   case '-':r=x1-x2;
                   break;
                   case '*':r=x1*x2;
                   break;
                   case '/':r=x1/x2;
                   break;
               }
               st.push(r);
           }
       }
       return st.top.data;
   }
    
  public static void main(String[] args)
  {
     String s = "35*62/+4- ";
     char[] postfix = s.toCharArray();
      System.out.println("Result: " + eval(postfix));
  }
}

class Node
{
    int data;
    Node next;
}
class Stack 
{
    Node top = null;
    
    public void push(int x)
    {
        Node t = new Node();
        
        if(t == null)
        {
            System.out.println("Stack overflow");
        }else
        {
            t.data = x;
            t.next = top;
            top = t;
        }
    }
    
    public int pop()
    {
        Node p;
        int x = -1;
        if(top == null)
        {
            System.out.println("Stack is Empty!");
        }else
        {
            p = top;
            top = top.next;
            x = p.data;
        }
        return x;
    }
    
}