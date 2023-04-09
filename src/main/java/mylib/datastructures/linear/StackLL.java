package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL{

    private SNode top;
    private int size;

    public StackLL() {
        top = null;
        size = 0;
    }

    public StackLL(SNode node) {
        top = node;
        size = 1;
    }

    //fix to call super
    public void push(int data) {
        SNode newNode = new SNode(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        size++;
    }

    //fix to call super
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    //fix to call super
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

}

