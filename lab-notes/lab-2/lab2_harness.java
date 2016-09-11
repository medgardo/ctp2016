// Lab 2 Solution
import java.util.*;
import java.util.Scanner;


/*********************************************************************/
// Write your code here



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
