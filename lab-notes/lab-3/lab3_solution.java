import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


/*********************************************************************/
// Write your code here


/*
 * Complete the function below.
 */

    static void customSort(int[] arr) {
      // Sum frequencies (as values) of each value in arr[] (as keys).
      Map<Integer, Integer> freq = new TreeMap<Integer, Integer>();

      for (int i : arr) {
        if(freq.get(i) != null) {
          freq.put(i, freq.get(i)+1);
        } else {
          freq.put(i, 1);
        }
      }

      // Create a new map, swapping freq's values and keys. Since there can be multiple keys per
      // frequency value, we collect them in an arraylist.
      Map<Integer, ArrayList<Integer>> sorted_freq = new TreeMap<Integer, ArrayList<Integer>>();

      for(int key : freq.keySet()) {
        int val = freq.get(key);

        ArrayList<Integer> kl;

        if(sorted_freq.get(val) != null) {
          kl = sorted_freq.get(val);
        } else {
          kl = new ArrayList<Integer>();
        }

        kl.add(key);
        sorted_freq.put(val, kl);
      }


      // Print all entries in sorted order.
      for( Map.Entry<Integer,ArrayList<Integer>> e : sorted_freq.entrySet()) {
        ArrayList<Integer> list = e.getValue();
        for(int i: list)  {
          // Print each value the number of times it appeared in arr[]
          for(int times=0; times<e.getKey(); times++) {
            System.out.println(i);
          }
        }
      }
    }


// Write your solution above
/*********************************************************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        customSort(_arr);

    }
}

