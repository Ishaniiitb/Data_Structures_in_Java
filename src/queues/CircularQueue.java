package queues;

import linkedLists.CircularLinkedList;
import linkedLists.Node;

public class CircularQueue<E> {

    public CircularLinkedList<E> circularQueue;
    public Node<E> front;
    public Node<E> end;
    public int size;

    public CircularQueue() {
        this.circularQueue = new CircularLinkedList<>();
        this.front = this.circularQueue.head;
        this.end = this.circularQueue.tail;
        this.size = 0;
    }

    public CircularQueue(E[] data) {
        this.circularQueue = new CircularLinkedList<>(data);
        this.front = this.circularQueue.head;
        this.end = this.circularQueue.tail;
        this.size = this.circularQueue.getSize();
    }

    public void enqueue(E element) {this.circularQueue.addAtEnd(element);}
    public void dequeue() {this.circularQueue.delAtBeg();}

    public int getSize() {return this.circularQueue.getSize();}

    public void rotate()
    {
        if(this.getSize() > 1) {
            this.end = this.front;
            this.front = this.front.getNext();
        }
    }

    public E firstInQueue() {return this.front.getData();}
    public E lastInQueue() {return this.end.getData();}


}