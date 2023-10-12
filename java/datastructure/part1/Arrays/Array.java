package part1.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {

    private Integer [] liste ;
    private int count = 0;
    public Array(int size){
        this.liste = new Integer[size];
    }
    public void  add(int item) {
        if (count == this.liste.length) {
            Integer[] newList = new Integer[2 * this.liste.length];
            for (int i = 0; i < this.liste.length; i++) {
                newList[i] = this.liste[i];
            }
            this.liste = newList;
        }
        this.liste[count] = item;
        count++;
    }
    public void removeAt(int indexItem){
        Integer [] copy = new Integer[this.liste.length];
        int ind =0;
        for(int i=0 ; i < this.liste.length;i++){
            if ( i != indexItem){
               copy[ind]=liste[i];
               ind ++;
            }else{
                count--;
            }
        }
        this.liste=copy;
    }
    public int indexOf(int item){
        for(int i = 0; i < count; i++){
            if (this.liste[i]  == item){
            return i;
            }
        }
       return -1;
    }
    public void print(){
        System.out.println(Arrays.toString(this.liste));
    }

    public int max(){
        int max = this.liste[0];
        for (int i=0;i<count;i++){
            if(this.liste[i]>max){
                max=liste[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Array a = new Array(4);
        ArrayList b = new ArrayList<>();
        b.add(12);
        System.out.println(b.toString());

        a.add(12);
        a.add(13);
        a.add(17);
        a.add(16);
        a.add(14);
        a.add(177);
        a.add(172);
        a.add(171);
        a.add(147);
        a.removeAt(1);
        System.out.println( a.max());
        a.print();
    }

}

