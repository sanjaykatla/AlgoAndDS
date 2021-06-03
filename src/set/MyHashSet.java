package set;

public class MyHashSet {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private final int size;
    private final Node[] arr;

    public MyHashSet() {
        size = 1000;
        arr = new Node[size];
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        int hash = key % size;
        Node node = new Node(key);
        if (arr[hash] == null) {
            arr[hash] = node;
        } else {
            Node temp = arr[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void remove(int key) {
        int hash = key % size;
        if (arr[hash] == null) {
            return;
        }
        Node prev = null;
        Node cur = arr[hash];

        while (cur.data != key) {
            prev = cur;
            cur = cur.next;
        }
        if (prev == null) {
            arr[hash] = cur.next;
        } else {
            prev.next = cur.next;
        }
    }

    //* Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % size;
        if (arr[hash] != null) {
            Node cur = arr[hash];

            while (cur != null) {
                if (cur.data == key) {
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        final MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
