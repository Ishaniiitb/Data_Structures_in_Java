package queues;

import linkedLists.LinearLinkedList;
import linkedLists.Node;

public class LinearQueue<E> implements Queues<E>{

    LinearLinkedList<E> linearQueue;
    Node<E> front;
    Node<E> end;
    int queueSize;
    public LinearQueue()
    {
        this.linearQueue = new LinearLinkedList<>();
        this.front = this.linearQueue.head;
        this.end = this.linearQueue.tail;
        this.queueSize = 0;
    }

    public LinearQueue(E[] data)
    {
        this.linearQueue = new LinearLinkedList<>(data);
        this.front = this.linearQueue.head;
        this.end = this.linearQueue.tail;
        this.queueSize = this.linearQueue.getSize();
    }

    public void Enqueue(E element)
    {
        this.linearQueue.addAtEnd(element);
        this.queueSize++;
    }

    public void Dequeue()
    {
        this.linearQueue.delAtBeg();
        this.queueSize--;
    }

    public E front() {return this.front.getData();}
    public E back() {return this.end.getData();}
    public int searchElement(E element) {return this.linearQueue.searchElement(element);}


}
