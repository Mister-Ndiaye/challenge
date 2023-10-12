package part1.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int [] liste;
    private int fist=0 ;
    private int last=0 ;
    private int size=0 ;

    public ArrayQueue(int size){
        this.liste = new int[size];
        this.size=size;
    }
    public void enqueu(int item){
        if(last==size && fist==0){
            System.out.println("Fulll");
        }else{
            liste[last%size]=item;
            last++;
        }
    }
    public void dequeu(){
        fist++;
        fist%=size;
    }
    public int peek(){
        return liste[fist];
    }
    public boolean isEmpty(){
        return last==0;
    }
    public boolean isFull(){
        return false;
    }

    @Override
    public String toString() {
        int [] newArray = new int[last-fist];
        for(int i=0;i<last-fist;i++){
            newArray[i]=liste[(fist+i)%size];
        }
        return "ArrayQueue{" +
                "liste Original" + Arrays.toString(liste) +
                "liste=" + Arrays.toString(newArray) +
                ", fist=" + fist +
                ", last=" + last +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue= new ArrayQueue(5);
        arrayQueue.enqueu(10);
        arrayQueue.enqueu(20);
        arrayQueue.enqueu(30);
        arrayQueue.enqueu(40);
        arrayQueue.enqueu(50);
        arrayQueue.dequeu();
        arrayQueue.dequeu();
        arrayQueue.enqueu(60);

        System.out.println(arrayQueue);
    }
}
