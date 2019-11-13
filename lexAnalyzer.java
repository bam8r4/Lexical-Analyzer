//Author of code:Brent Moran
import java.io.*;
import java.util.*;

public class LexAnalyzer
{
   //variables 
   char [] lexeme = new char[100];
   private int lexLen = 0;
   private int token;
   private int nextToken;
   private String output = "";
   
   //Character Classes 
   private static final int LETTER=0;
   private static final int DIGIT=1;
   private static final int UNKNOWN=99; 
    
   //Token codes 
   private static final int INT_LIT=10;
   private static final int IDENT=11;
   private static final int ASSIGN_OP=20; 
   private static final int ADD_OP=21;
   private static final int SUB_OP=22;
   private static final int MULT_OP=23;
   private static final int DIV_OP=24; 
   private static final int LEFT_PAREN=25;
   private static final int RIGHT_PAREN=26; 
   private static final int EOF=-1;
   
   public void lookup(char ch) {
       
     switch (ch) {
        
      case '(':
        
        nextToken = LEFT_PAREN;
        break;
   
      case ')':
       
        nextToken = RIGHT_PAREN;
        break;
   
      case '+':
        
        nextToken = ADD_OP;
        break;
   
      case '-':
        
        nextToken = SUB_OP;
         break;
   
      case '*':
        
        nextToken = MULT_OP;
        break;
   
      case '/':
        
        nextToken = DIV_OP;
        break;
        
      case '=':
        
        nextToken = ASSIGN_OP;
        break;
   
      default:
        
        nextToken = EOF;
        break;
     }
    
    this.token = nextToken;
 
  }
  
    
    public void increment()
    {
        this.lexLen++;
    }
    
    public void lexLenReset()
    {
        this.lexLen = 0;
    }
    
     public void lex(char ch)
   {
       this.lexeme[lexLen]  = ch;
   }
   
   public void makeString(char ch)
   {
       this.output += ch;
   }
   
   public void buildString()
   {
       for(int i = 0; i<=lexLen; i++)
       {
           this.output += lexeme[i];
       }
   }
   
   public void sanitize()
   {
       for(int i =  0; i<100; i++)
       {
           this.lexeme[i]  =  '0';
       }
   }
   
   public void display()
   {
       System.out.println("Next token is: " +token+ " Next lexeme is " + output);
   }
   
   public void regDisplay()
   {
        System.out.println("Next token is: " +token+ " Next lexeme is " + lexeme[0]);
   }
   
   public void setDigit()
   {
       this.nextToken = DIGIT;
   }
   
   public void setLetter()
   {
       this.nextToken =  LETTER;
   }
   
   public void purgeOutput()
   {
       this.output = "";
   }
}
      
