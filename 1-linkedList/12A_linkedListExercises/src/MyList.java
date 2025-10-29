
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null; //chưa có node nào
    }

    boolean isEmpty() {
        return (head == null); //kiểm tra danh sách có node không
    }

    void clear() {
        head = tail = null; //hàm xoá toàn bộ node, gọi hàm này là xoá hết
    }

    // (1) 
    void addLast(Person x) { //thêm 1 node có nội dung là x vào cuối danh sách
        Node q = new Node(x); //kiểm tra bên Node.java, next = null tự động
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q; //node tail ban đầu sẽ giữ địa chỉ của node q mới tạo
        tail = q; //khởi tạo node tail là node q
    }
//in ra node 
    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }
//in ra từng node trong linked list
    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i])); //tạo 1 person mới
        }
    }

    // (2) //tìm node bởi tên, duyệt từ head đến tên cần tìm rồi trả về
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    // (3)
    void addFirst(Person x) {
        Node q = new Node(x);
        if(isEmpty()){
            head = tail = q;
            return;
        }
        q.next = head; //dùng next của q để lấy địa chỉ của node đầu trong head
        head = q; //đặt head = q
    }

    // (4)
    void insertAfter(Node q, Person x) {
        Node a = new Node(x);
        if(isEmpty()){
            head = tail = a;
            return;
        }
        a.next = q.next;
        q.next = a;
        if(q == tail){
            tail = a;
        }


    }

    // (5)
    void insertBefore(Node q, Person x) {
        Node a = new Node(x);
        if(isEmpty()){
            head = tail = a;
            return;
        }
        if(q == head){
            a.next = head;
            head = a;
            return;//ngăn chạy đoạn code phía dưới
        }
        Node pre = head;
        //tìm node trc của q
        while(pre != null && pre.next != q){
            pre = pre.next;
        }
        if(pre != null){
            pre.next = a;
            a.next = q;
        }      
    }

    // (6)
    void remove(Node q) {
        if(head==null) return;
        if(head==q){
            head = head.next;
            return;
        }
        Node pre = head;
        while(pre != null && pre.next!=q){
            pre = pre.next;
        }
        pre.next = q.next;
        if(pre.next == null){
            tail = pre;
        }
    }

    // (7)
    void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }

    // (8)
    Node searchByAge(int xAge) {
        Node pre = head;
        while(pre!=null){
            if(pre.info.age==xAge){
                return (pre);
            }
            pre = pre.next;
        }
        return (null);
    }
    
    void remove(int xAge){
        Node q = searchByAge(xAge);
        remove(q);
    }

    // (9)
    void removeAll(int xAge) {
        if(head==null) return;
        if(head!=null&&head.info.age==xAge){
            head = head.next;
        }
        Node pre = head;
        while(pre!=null&&pre.next!=null){
            if(pre.next.info.age==xAge){
                pre.next = pre.next.next;
            } else{
                pre = pre.next;
            }
        }
    }

    // (10)
    Node pos(int k) {
        if(head==null) return null;
        Node p = head;
        int a = 0;
        while(p!=null){
            p = p.next;
            a++;
            if(a==k){
                return (p);
            }
        }
        return (null);
    }

    // (11)
    void removePos(int k) {
    }

    // (12)
    void sortByName() {
    }

    // (13)
    void sortByAge() {
    }

    // (14)
    int size() {
        return (0);
    }

    // (15)
    Person[] toArray() {
        return (null);
    }

    // (16)
    void reverse() {
    }

    // (17) 
    Node findMaxAge() {
        return (null);
    }

    // (18) 
    Node findMinAge() {
        return (null);
    }

    // (19) 
    void setData(Node p, Person x) {
    }

    // (20) 
    void sortByAge(int k, int h) {
    }

    // (21) 
    void reverse(int k, int h) // reverse from k to h 
    {
    }
}
