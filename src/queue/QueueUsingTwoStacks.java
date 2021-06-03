package queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingTwoStacks<T> {

    private final Stack<T> stack1;
    private final Stack<T> stack2;
    private final int size;

    QueueUsingTwoStacks(int size){
        this.stack1 = new Stack<T>();
        this.stack2 = new Stack<T>();
        this.size = size;
    }

    public boolean add(T t) throws IllegalStateException, ClassCastException, NullPointerException, IllegalArgumentException
    {
        if(offer(t)){
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean offer(T t) throws ClassCastException, NullPointerException, IllegalArgumentException
    {
        if(stack1.size() + stack2.size() == size)
        {
            return false;
        }

        return stack1.add(t);
    }

    public T remove() throws NoSuchElementException
    {
        T t = poll();
        if(t == null){
            throw new NoSuchElementException();
        }
        return t;

    }

    public T poll()
    {
        if(stack2.isEmpty() && stack1.isEmpty()){
            return null;
        }
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

    public T element() throws NoSuchElementException
    {
        T t = peek();
        if(t == null){
            throw new NoSuchElementException();
        }
        return t;
    }

    public T peek()
    {
        if(stack2.isEmpty() && stack1.isEmpty()){
            return null;
        }
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    public int size(){
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
