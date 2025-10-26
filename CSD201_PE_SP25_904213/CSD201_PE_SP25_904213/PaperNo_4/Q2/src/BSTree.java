/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xDesert, int xStep, int xType) {
        //You should insert here statements to complete this function

        if (xDesert.charAt(0) == 'B') {
            return;
        }

        Camel newCamel = new Camel(xDesert, xStep, xType);
        Node newNode = new Node(newCamel);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;

            while (current != null) {
                parent = current;
                if (xStep < current.info.step) {
                    current = current.left;
                } else if (xStep > current.info.step) {
                    current = current.right;
                } else {
                    return;
                }
            }

            if (xStep < parent.info.step) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        preOrder2(root, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.type > 4) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.
         */

        Node thirdNode = findNodeAtPosition(root, 3);
        int subtreeSize = calculateSubtreeSize(thirdNode);
        thirdNode.info.type = subtreeSize;

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    Node findNodeAtPosition(Node p, int position) {
        if (p == null) {
            return null;
        }
        // Perform pre-order traversal and track the position
        Node foundNode = findNodeAtPositionHelper(p, position, new int[]{0});
        return foundNode;
    }

    Node findNodeAtPositionHelper(Node p, int position, int[] counter) {
        if (p == null) {
            return null;
        }
        counter[0]++;
        if (counter[0] == position) {
            return p;
        }

        Node left = findNodeAtPositionHelper(p.left, position, counter);
        if (left != null) {
            return left;
        }

        return findNodeAtPositionHelper(p.right, position, counter);
    }

    int calculateSubtreeSize(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + calculateSubtreeSize(p.left) + calculateSubtreeSize(p.right);
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

      Node secondNodeWithLeftChild = findSecondNodeWithLeftChild(root);
    if (secondNodeWithLeftChild != null) {
        rotateRight(secondNodeWithLeftChild);
    }
    

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

   Node findSecondNodeWithLeftChild(Node p) {
    if (p == null) return null;
    return findSecondNodeWithLeftChildHelper(p, new int[] {0});
}

Node findSecondNodeWithLeftChildHelper(Node p, int[] counter) {
    if (p == null) return null;

    Node left = findSecondNodeWithLeftChildHelper(p.left, counter);
    if (left != null) return left;

    if (p.left != null) {
        counter[0]++;
        if (counter[0] == 2) return p;  
    }

    return findSecondNodeWithLeftChildHelper(p.right, counter);
}

void rotateRight(Node p) {
    if (p == null || p.left == null) return;  

    Node leftChild = p.left;
    p.left = leftChild.right;
    leftChild.right = p;

    if (p == root) {
        root = leftChild;
    }
}
}