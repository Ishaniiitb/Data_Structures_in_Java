package linkedLists;

public class CircularLinkedList<E>{

    private int size;
    public LinearLinkedList<E> circularLinked;
    public Node<E> head;
    public Node<E> tail;

    public CircularLinkedList()
    {
        this.circularLinked = new LinearLinkedList<>();
        this.head = this.circularLinked.head;
        this.tail = this.circularLinked.tail;
        this.size = circularLinked.getSize();
    }

    public CircularLinkedList(E[] data)
    {
        this.circularLinked = new LinearLinkedList<>(data);
        this.size = circularLinked.getSize();
        this.head = this.circularLinked.head;
        this.tail = this.circularLinked.tail;
        this.tail.setNext(this.head);
    }

    public void addAtBeg(E element)
    {
        Node<E> eNode = new Node<>(element, this.head);
        this.tail.setNext(eNode);
        this.head = eNode;
        this.size++;
    }

    public void addAtEnd(E element)
    {
        Node<E> eNode = new Node<>(element, this.head);
        this.tail.setNext(eNode);
        this.tail = eNode;
        this.size++;
    }

    public E delAtBeg()
    {
        Node<E> temp = this.head;
        E data = temp.getData();
        this.head = this.head.getNext();
        this.tail.setNext(this.head);
        temp = null;
        this.size--;
        return data;
    }

    public void display()
    {
        Node<E> track = this.head;
        do
        {
            track.displayNode();
            track = track.getNext();
        }while(track != this.head);
    }

    public int searchElement(E element)
    {
        int position = 1;
        Node<E> track = this.head;
        do {
            if(track.getData() == element)
                return position;
            position++;
            track = track.getNext();
        }while(track != this.head);
        return -1;
    }

    public void delElement(E element)
    {
        if(this.head.getData() == element) {
            delAtBeg();
            return;
        }
        Node<E> track = this.head;
        while(track.getNext() != this.head && track.getNext().getData() != element)
            track = track.getNext();
        if(track == this.tail)
        {
            System.out.println("Element not present");
            return;
        }
        Node<E> temp = track.getNext();
        track.setNext(temp.getNext());
        temp = null;
        this.size--;
    }

    public int getSize() {return this.size;}

}
