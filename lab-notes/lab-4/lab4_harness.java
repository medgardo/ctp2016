import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
 * Complete the function below.
 */

    static void createBST(int[] keys) {


    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _keys_size = 0;
        _keys_size = Integer.parseInt(in.nextLine().trim());
        int[] _keys = new int[_keys_size];
        int _keys_item;
        for(int _keys_i = 0; _keys_i < _keys_size; _keys_i++) {
            _keys_item = Integer.parseInt(in.nextLine().trim());
            _keys[_keys_i] = _keys_item;
        }

        createBST(_keys);

    }
}
