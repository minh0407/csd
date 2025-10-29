/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;
class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xOwner, int xPrice)
   {//You should write here appropriate statements to complete this function.
       
   Car x  = new Car(xOwner, xPrice);
   Node q = new Node (x, null);
   if(xOwner.charAt(0)=='B'|| xPrice>100){
   return ;
   }
     if(isEmpty()){
            head = tail = q;
            return;
        }       
     tail.next = q;
        tail = q;
   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
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
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Car x = new Car("X",1);
     Car y = new Car("Y",2);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    addfirst( x);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  
  
  void addfirst(Car x){
  Node p = new Node( x);
  if(isEmpty()){
  head = tail = p ; 
  
  }else{
  p.next=head;
  head = p;
  }
      
  }

//==================================================================
  void f3() throws Exception
   {clear();
    loadData(7);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

deleteByAge(5);

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }
Node searchByAge(int x){ //3.
        if(isEmpty()){
            return null;
        }
        Node a = head;
        while(a!=null){
            if(a.info.price == x){
                return a;
            }
            a=a.next;
        }
        return null;
    }
 void removeFirst(){ //TH1: xoá node là head
        if(isEmpty()){
            return;
        }
        head = head.next;
        if(head == null){ //nếu có duy nhất 1 node, thì phải cập nhật head = tail = null
            tail = null;
        }
    }
 void delete(Node p){ //xoá 1 node, có 4 trường hợp
        if(isEmpty() || p == null){ //danh sách rỗng
            return;
        }
        if(p==head){ // xoá node là 
            removeFirst();
            return;
        }
        Node f = head;
        while(f.next!=p){
            f=f.next;
        }
        f.next = p.next;
        if(f.next == null){ //xoá node p là tail, thì phải cập nhật tail là f
            tail = f;
        }
    }
 void deleteByAge(int x){
        Node q = searchByAge(x);
        delete(q);
    }
//==================================================================
  void f4() throws Exception
   {clear();
    loadData(10);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

sort();

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
    
   }
void sort(){
Node q , p ; 
Car x ; 
for(p = head ; p != null ; p = p.next){
for(q = p.next;q !=null ; q = p.next){
if(q.info.price< p.info.price){
x = p.info;
p.info = q.info;
q.info = x;
}
}
}
}
 }
