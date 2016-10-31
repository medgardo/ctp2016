// Lab 2 Solution
import java.util.*;
import java.util.Scanner;


/*********************************************************************/
// Write your code here

class Parser {

    public Parser() {}

    private boolean isOpen(char c) {
        return (c == '(' || c == '{');
    }

    private boolean isClose(char c) {
        return (c == ')' || c == '}');
    }

    private boolean isMatch(char a, char z) {
        if (a == '{' && z == '}')
            return true;
        if (a == '(' && z == ')')
            return true;

        return false;
    }

    public boolean checkParenthesesBalance(String str) {
        Stack s = new Stack();

        for(char c: str.toCharArray()) {
            if( isOpen(c) ) {
                s.push(c);
            } else if( isClose(c)) {
                if (s.empty())
                    return false;
                char t = (char)s.pop();
                if (!isMatch(t,c))
                    return false;
            }
        }

        if(s.empty())
            return true;
        else
            return false;
    }
}

// Write your solution above
/*********************************************************************/

class Solution{

  public static void main(String []argh)
  {
    Parser X=new Parser();
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      System.out.println(X.checkParenthesesBalance(in.next()));
    }

  }
}
