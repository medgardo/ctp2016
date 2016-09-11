import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

/*********************************************************************/
// Write your code here
/*
 * Complete the function below.
 */
/*
For your reference:
LinkedListNode {
    int val;
    LinkedListNode *next;
};
*/

    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode cur;

        // Check if we have to update the head of the list. We do this
        //  when the first item in the list is greater than x.
        while(list != null && list.val > x) {
            list = list.next;
        }

        // If the list is empty, or we removed all items, then return
        //  the empty list
        if( list == null )
            return list;

        // Use cur to traverse the list
        cur = list;

        // At this point, cur.val is valid. So I need to check cur.next.val
        while(cur.next != null) {
            if (cur.next.val > x) {
                cur.next = cur.next.next; // skip the node
            } else {
                cur = cur.next; // don't skip, just update cur
            }
        }

        return list; // return the head of the list
    }

    // Another alternative implementation is to create a second list which
    //  inserts nodes less than or equal to x. Then return the head of that list.


/*********************************************************************/


    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        LinkedListNode res;

        int _list_size = 0;
        _list_size = Integer.parseInt(in.nextLine());
        int _list_i;
        int _list_item;
        LinkedListNode _list = null;
        LinkedListNode _list_tail = null;
        for(_list_i = 0; _list_i < _list_size; _list_i++) {
            _list_item = Integer.parseInt(in.nextLine().trim());
            if(_list_i == 0) {
          _list = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
          _list_tail = _list;
        }
        else {
          _list_tail = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
        }
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = removeNodes(_list, _x);
        while (res != null) {
            bw.write(String.valueOf(res.val));
            bw.newLine();
            res = res.next;
        }

        bw.close();
    }
}

