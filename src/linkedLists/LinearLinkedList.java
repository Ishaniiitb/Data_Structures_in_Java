package linkedLists;

import java.util.ArrayList;

public class LinearLinkedList<E> implements LinkedLists<E>{

    public Node<E> head;
    public Node<E> tail;
    private int size;
    public LinearLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinearLinkedList(E[] data)
    {
        for(E element : data)
        {
            if(this.head == null) {
                Node<E> eNode = new Node<>(element);
                this.head = this.tail = eNode;
                this.size++;
            }
            else
                addAtEnd(element);
        }
    }

    public void addAtEnd(E element)
    {
        Node<E> eNode = new Node<>(element);
        this.tail.setNext(eNode);
        this.tail = eNode;
        this.size++;
    }

    public void addAtBeg(E element)
    {
        this.head = new Node<>(element, this.head);
        this.size++;
    }

    public void addAtPosition(E element, int n)
    {
        if(n == 1)
            addAtBeg(element);
        else if(n > this.size)
            addAtEnd(element);
        else
        {
            Node<E> track = this.head;
            while(n > 2)
            {
                track = track.getNext();
                n--;
            }
            Node<E> eNode = new Node<>(element, track.getNext());
            track.setNext(eNode);
            this.size++;
        }
    }

    public int getSize() {return this.size;}

    public int searchElement(E element)
    {
        Node<E> track = this.head;
        int position = 1; boolean flag = false;
        while(track != null)
        {
            if(track.getData() == element) {
                flag = true;
                break;
            }
            track = track.getNext();
            position++;
        }
        if(flag)
            return position;
        else
            return -1;
    }

    public E delAtBeg()
    {
        Node<E> temp = this.head;
        this.head = this.head.getNext();
        E data = temp.getData();
        temp = null;
        return data;
    }

    public E delAtEnd()
    {
        Node<E> track = this.head;
        while(track.getNext() != this.tail)
            track = track.getNext();
        E data = this.tail.getData();
        this.tail = track;
        track = track.getNext();
        track = null;
        return data;
    }

    public void delElement(E element)
    {
        if(this.head.getData() == element)
        {
            delAtBeg();
            return;
        }
        Node<E> track = this.head;
        while(track.getNext() != null && track.getNext().getData() != element)
            track = track.getNext();
        if(track.getNext() == tail)
            delAtEnd();
        else if(track == tail)
            System.out.println("Element not found");
        else
        {
            Node<E> temp = track.getNext();
            track.setNext(temp.getNext());
            temp = null;
        }
    }

    public void display()
    {
        Node<E> track = this.head;
        while(track != null)
        {
            track.displayNode();
            track = track.getNext();
        }
    }

//    public ArrayList<E> toArray()
//    {
//        int len = this.getSize();
//        ArrayList<E> data = new ArrayList<E>();
//        Node<E> track = this.head;
//        while(track != null)
//        {
//            data.add(track.getData());
//            track = track.getNext();
//        }
//        return data;
//    }
//
//
//    public void sort(boolean reverse)
//    {
//        ArrayList<E> data = toArray();
//        int len = data.size();
//        if(!reverse)
//        {
//            for(int i = 0; i < len; i++)
//            {
//                for(int j = 0; j < len-i-1; j++)
//                {
//                    if(data.get(j) > data.get(j+1))
//
//                }
//            }
//        }
//    }
}
