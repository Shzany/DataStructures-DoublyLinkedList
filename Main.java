package LinkedList_DoublyLinkedList;
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtHead(12);
        doublyLinkedList.insertAtHead(11);
        doublyLinkedList.insertAtHead(10);
        doublyLinkedList.insertAtHead(9);
        doublyLinkedList.insertAtHead(8);
        doublyLinkedList.insertAtHead(7);

        doublyLinkedList.insertAtEnd(12);
        doublyLinkedList.insertAtEnd(11);
        doublyLinkedList.insertAtEnd(10);
        doublyLinkedList.insertAtEnd(9);
        doublyLinkedList.insertAtEnd(8);
        doublyLinkedList.insertAtEnd(7);

        doublyLinkedList.deleteAtHead();
        doublyLinkedList.deleteAtHead();
        doublyLinkedList.deleteAtHead();

        doublyLinkedList.deleteAtEnd();
        doublyLinkedList.deleteAtEnd();
        doublyLinkedList.deleteAtEnd();

        doublyLinkedList.deleteFromAnywhere(12);
        doublyLinkedList.deleteFromAnywhere(9);
        doublyLinkedList.deleteFromAnywhere(10);

        doublyLinkedList.printList();
    }
}
class Node {
    int data;
    Node next;
    Node prev;
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    void insertAtHead(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail=newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail=newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    void deleteAtHead(){
        head = head.next;
        head.prev = null;
    }
    void deleteAtEnd(){
        tail = tail.prev;
        tail.next = null;
    }
    void deleteFromAnywhere(int key){
        Node temp = null; //Sonda başta ve ortada durumları müsait bir zamanda değerlendirilecek
        while (temp.next.next.next != null && temp.data != key){
            if (temp.next.data == key){
                temp.next = temp.next.next;
                temp.prev.prev = temp;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Belirtilen değer bulunamadı");
    }
    void printList(){
        Node temp = head;
        System.out.println("Head = "+temp);
        while (temp!=null){
            System.out.print(temp.data);
            if (temp.next!=null)
                System.out.print( " <-> ");
            temp = temp.next;
        }
    }
}

