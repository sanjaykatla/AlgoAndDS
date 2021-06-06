package stack;

public class StackWithIncrement {

    private int[] arr;
    private int[] inc;
    private int index;

    public StackWithIncrement(int maxSize) {
        arr = new int[maxSize];
        inc = new int[maxSize];
        index = 0;
    }

    public void push(int x) {

        if(isFull()){
            return;
        }
        arr[index++] = x;
    }

    public int pop() {

        if(isEmpty()){
            return -1;
        }

        int res = arr[index-1] + inc[index-1];
        if(index - 2 >= 0){
            inc[index - 2] += inc[index - 1];
        }
        inc[index-1] = 0;
        index--;
        return res;
    }

    public void increment(int k, int val) {

        int pos = Math.min(index - 1, k - 1);
        if( pos >= 0){
            inc[pos] += val;
        }
    }

    private boolean isFull(){
        return index == arr.length;
    }

    private boolean isEmpty() {
        return index == 0;
    }
}
