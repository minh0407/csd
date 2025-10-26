/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xDesert, int xStep, int xType) {
        //You should write here appropriate statements to complete this function.

        if (xDesert.charAt(0) == 'B') {
            return;
        }

        Camel newCamel = new Camel(xDesert, xStep, xType);
        Node newNode = new Node(newCamel);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Camel x, y, z;
        x = new Camel("X", 1, 2);
        y = new Camel("Y", 2, 3);
        z = new Camel("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        insertAtPosition(x, 3);
        insertAtPosition(y, 5);
        insertAtPosition(z, 6);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

void insertAtPosition(Camel c, int pos) {
    Node newNode = new Node(c);
    Node p = head;

    for (int i = 1; i < pos - 1; i++) {
        p = p.next;
    }

    newNode.next = p.next;
    p.next = newNode;
}
//==================================================================

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node maxStepNode = findMaxStepNode();
        Node secondNode = head.next;

        Camel temp = maxStepNode.info;
        maxStepNode.info = secondNode.info;
        secondNode.info = temp;
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    Node findMaxStepNode() {
        Node p = head;
        Node maxNode = p;
        while (p != null) {
            if (p.info.step > maxNode.info.step) {
                maxNode = p;
            }
            p = p.next;
        }
        return maxNode;
    }
//==================================================================

    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = findNodeWithDesert("F");
        if (p != null) {
            reverseAfterNode(p);
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    Node findNodeWithDesert(String desert) {
        Node p = head;
        while (p != null) {
            if (p.info.desert.equals(desert)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void reverseAfterNode(Node p) {
        Node prev = null;
        Node curr = p.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        p.next = prev;
    }

}
