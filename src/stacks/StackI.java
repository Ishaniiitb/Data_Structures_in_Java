package stacks;

import linkedLists.LinearLinkedList;

public class StackI<E> implements Stacks<E>{

    LinearLinkedList<E> stack;
    int size;
    public StackI()
    {
        this.stack = new LinearLinkedList<E>();
        this.size = this.stack.getSize();
    }
    public StackI(E[] data)
    {
        this.stack = new LinearLinkedList<>(data);
        this.size = this.stack.getSize();
    }

    public E pop()
    {
        if(this.isEmpty()) {
            System.out.println("Underflow");
            return null;
        }
        else
            return this.stack.delAtBeg();
    }

    public void push(E element)
    {
        this.stack.addAtBeg(element);
    }

    public int size() {return this.stack.getSize();}

    public boolean isEmpty() {return this.size() == 0;}

    public E top() {return this.stack.head.getData();}
}
