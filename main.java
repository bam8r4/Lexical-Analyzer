//Author of code:Brent Moran
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	 
	LexAnalyzer lexer = new LexAnalyzer(); 
	  
	boolean sameDig = false;  
    boolean sameLett = false;
    
    lexer.sanitize();
    lexer.purgeOutput();
        
        try
        {
             InputStream in = new FileInputStream("input.txt");
             Reader reader = new InputStreamReader(in);

             int c;
             while ((c = reader.read()) != -1) {
                 
                if((char) c == ' ')
                {
                    continue;
                }
                else
                {
                    
                   if(Character.isDigit((char)c))
                    {
                        sameDig = true;
                        lexer.setDigit();
                        lexer.makeString((char)c);
                        lexer.increment();
                        continue;
                    }
                    
                    if(sameDig)
                    {
                        lexer.buildString();
                        lexer.display();
                        lexer.sanitize();
                        lexer.lexLenReset();
                        lexer.purgeOutput();
                    }
                    
                    if(Character.isLetter((char)c))
                    {
                        sameLett = true;
                        lexer.setLetter();
                        lexer.makeString((char)c);
                        lexer.increment();
                        continue;
                    }
                    
                    if(sameLett)
                    {
                        lexer.buildString();
                        lexer.display();
                        lexer.sanitize();
                        lexer.lexLenReset();
                        lexer.purgeOutput();
                    }
                    
                    lexer.lookup((char) c);
                    lexer.lex((char) c);
                    lexer.regDisplay();
                    lexer.sanitize();
                    lexer.lexLenReset();
                    
                }
             }
        }
        catch(Exception e)
        {
           e.printStackTrace(); 
        }
	}
}
