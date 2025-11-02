import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//==================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xMaker, int xVolume, int xColor) {
    //You should write here appropriate statements to complete this function.
Bottle x = new Bottle(xMaker , xVolume , xColor);
    Node node = new Node(x);
    if(x.maker.charAt(0)=='A'){return;}
    if (isEmpty()) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Bottle x, y, z;
     x = new Bottle("X",1,2);
     y = new Bottle("Y",2,3);
     z = new Bottle("Z",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

addAfterIndex( x , 1);
addAfterIndex( y , 2);
addAfterIndex( z , 4);
    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  
  void addAfterIndex(Bottle x , int index) {
    if (index < 0) {
      addFirst(x);
      return;
    }
    if (index >= size()) {
      addLast(x);
      return;
    }
    int count = 1;
    Node cur = head;
    while (cur != null && count != index) {
      count++;
      cur = cur.next;
    }
    if (cur != null) {
      Node node = new Node( x );
      node.next = cur.next;
      cur.next = node;
    }
  }
   int size() {
    Node cur = head;
    int k = 0;
    while (cur != null) {
      k++;
      cur = cur.next;
    }
    return k;
  }

  // Add last node
  void addLast(Bottle x ) {
    Node node = new Node(x);
    if (isEmpty()) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  // Add first node
  void addFirst(Bottle x ) {
    Node node = new Node(x);
    if (isEmpty()) {
      head = tail = node;
    } else {
      node.next = head;
      head = node;
    }
  }

//==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

 findMax() ;
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }   
    void findMax() {
    if (isEmpty()) return;
    if(size()<3) return ;
    int count = 0;
    Node maxNode = head;
    Node cur = head.next;
    while (cur != null) {
      
        if (cur.info.color > maxNode.info.color) {
            maxNode = cur;
        }
        cur = cur.next;
       
    }
  Node p = maxNode ;
  p.info = maxNode.info;
  
   delete(maxNode);
   addAfterIndex(p.info,0);
}
    void delete(Node q) {
    if (isEmpty() || q == null) return;
    if (q == head) {
      deleteFirst();
      return;
    }
    Node f = head;
    while (f != null && f.next != q) f = f.next;
    if (f == null) return;
    Node q1 = q.next;
    f.next = q1;
    if (f.next == null){ tail = f;q.next = null;}
  }
      void deleteLast() {
    if (isEmpty()) {
      System.out.println("Empty list!");
      return;
    }
    if (head.next == null) {
      head = null;
    }
    Node cur = head;
    while (cur.next.next != null) {
      cur = cur.next;
    }
    cur.next = null;
    tail = cur;
  }

  // Delete first node
  void deleteFirst() {
    if (isEmpty()) {
      System.out.println("Empty list!");
      return;
    }
    if (head.next == null) {
      head = null;
    }
    Node cur = head;
    head = cur.next;
  }

//==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/



    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

