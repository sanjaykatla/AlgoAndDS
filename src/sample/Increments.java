package sample;

public class Increments {

    public static void main(String[] args){

        for(int i= 0 ;i <10; i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        for(int i= 0 ;i <10; ++i){
            System.out.print(i+ " ");
        }

        int c = 1;
        System.out.println();
        System.out.println(c++);
        System.out.println(++c);
        System.out.println(c++);
        System.out.println(++c);
    }
}
