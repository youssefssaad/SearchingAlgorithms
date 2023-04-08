package mylib.datastructures.linear;


import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
    private SNode head;
    private SNode tail;
    private int size;

    public CSLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public CSLL(SNode node) {
        this.head = node;
        this.head.setNext(head);
        this.tail = node;
        this.size = 1;
    }

    @Override
    public void insertHead(SNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(head);
        } else {
            node.setNext(head);
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            head = node;
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(head);
        } else {
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(node);
            node.setNext(head);
        }
        size++;
    }

    @Override
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    @Override
    public void sortedInsert(SNode node) {
        if (isEmpty()) {
            insertHead(node);
        } else if (node.getData() <= head.getData()) {
            insertHead(node);
        } else {
            SNode current = head;
            while (current.getNext() != head && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    @Override
    public SNode search(SNode node) {
        SNode current = head;
        do {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        } while (current != head);
        return null;
    }

    @Override
    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else {
            SNode current = head;
            while (current.getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head.getNext());
            head = head.getNext();
            size--;
        }
    }

    @Override
    public void deleteTail() {
        if (isEmpty()) {
            System.out.println("List is empty!");
        } else if (head.getNext() == head) {
            head = null;
            size--;
        } else {
            SNode current = head;
            while (current.getNext().getNext() != head) {
                current = current.getNext();
            }
            current.setNext(head);
            size--;
        }
    }

    @Override
    public void delete(SNode node) {
        if (isEmpty()) {
            System.out.println("List is empty. Deletion failed.");
            return;
        }
    
        if (head == node) {
            head = node.getNext();
            tail.setNext(head);
            size--;
            return;
        }
    
        SNode current = head;
        while (current.getNext() != head) {
            if (current.getNext() == node) {
                current.setNext(node.getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    
        if (tail == node) {
            tail = current;
            tail.setNext(head);
            size--;
            return;
        }
    
        System.out.println("Node not found. Deletion failed.");
    }
    
    @Override
    public void sort() {
        if (isEmpty()) {
            System.out.println("List is empty. Sort failed.");
            return;
        }
    
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            SNode current = head;
            while (current.getNext() != head) {
                if (current.getData() > current.getNext().getData()) {
                    int temp = current.getData();
                    current.setData(current.getNext().getData());
                    current.getNext().setData(temp);
                    swapped = true;
                }
                current = current.getNext();
            }
        }
    }
    
    @Override
    public boolean isSorted() {
        if (isEmpty() || head == tail) {
            return true;
        }
    
        SNode current = head;
        while (current.getNext() != head) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
    
        System.out.print("List: ");
        SNode current = head;
        do {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        } while (current != head);
        System.out.println("\nList Length: " + size);
        System.out.println("Sorted Status: " + isSorted());
    }

    public boolean isEmpty() {
        return head == null;
    }
}    
       


