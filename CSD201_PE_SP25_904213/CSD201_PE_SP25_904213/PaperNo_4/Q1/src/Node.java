// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Camel info;
  Node next;
  Node() {
   }
  Node(Camel x, Node p) {
    info=x;next=p;
   }
  Node(Camel x) {
    this(x,null);
   }
 }

