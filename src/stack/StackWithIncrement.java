package stack;

public class StackWithIncrement {

    private int[] arr;
    private int index;
    private int size;

    public StackWithIncrement(int maxSize) {
        arr = new int[maxSize];
        index = -1;
        size = maxSize;
    }

    public void push(int x) {

        if(isFull()){
            return;
        }
        arr[++index] = x;
    }

    public int pop() {

        if(isEmpty()){
            return -1;
        }
        return arr[index--];
    }

    public void increment(int k, int val) {

        for(int i =0; i< k && i<=index; i++ ){
            System.out.println("Incrementing: "+ i +" "+ arr[i]);
            arr[i] += val;
        }
    }

    private boolean isFull(){
        return index == size-1;
    }

    private boolean isEmpty() {
        return index < 0;
    }
}
