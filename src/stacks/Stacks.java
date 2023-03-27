package stacks;

public interface Stacks<E>{

    E pop();
    void push(E element);
    int size();
    boolean isEmpty();
    E top();
}
