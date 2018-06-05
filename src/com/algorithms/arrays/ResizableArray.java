package com.algorithms.arrays;


/**
 *  ArrayList implementation
 */
public class ResizableArray<E> {

    Object array[];
    int capacity=1;
    int size=0;

    ResizableArray(){
        array=new Object[capacity];
    }

    E get(int index){
        if(index<0)
            throw new IndexOutOfBoundsException();
        return (E) array[index];
    }

    void add(E item){
        System.out.println("adding item "+item);
        if(isFull()){
            System.out.println("array is full");
            size_up();
        }
        array[size++]=item;
        System.out.println("added item:"+item);


    }

    void size_up(){
        capacity=capacity*2;
        System.out.println("doubling capacity: "+capacity);
        Object[] arrayTemp= new Object[capacity];
        for(int i=0;i<size;i++){
            arrayTemp[i]=array[i];
        }
        array=arrayTemp;
    }
    void size_down(){
        capacity=capacity/2;
        System.out.println("shrinking capacity: "+capacity);
        Object[] arrayTemp= new Object[capacity];
        for(int i=0;i<size;i++){
            arrayTemp[i]=array[i];
        }
        array=arrayTemp;
    }

    void add(int item,int index) {

    }
    void remove(){
        System.out.println("removing from last");
        if(!isEmpty()) {
            size--;
            if (isOneFourthFull()) {
                System.out.println("array is one fourth full");
                size_down();
            }
        }else{
            System.out.println("array is empty");
            System.out.println("nothing to remove");
        }
    }

    void remove(int item,int index){

    }

    int size(){
        return size;
    }

    boolean isFull(){
        return size==capacity;
    }
    boolean isEmpty(){

        return size<=0;
    }

    boolean isOneFourthFull(){

        return size==(capacity/4);
    }

    void print(){
        System.out.println("size="+size);
        for(int i=0;i<size;i++){
            System.out.print(" " + array[i]);
        }
        System.out.println(" ");
    }

    public static void main(String args[]){
        ResizableArray<Integer> resizeArray = new ResizableArray();
        resizeArray.add(10);
        resizeArray.add(20);
        resizeArray.add(30);
        resizeArray.add(40);
        resizeArray.add(50);
        resizeArray.print();
        resizeArray.remove();
        resizeArray.print();
        resizeArray.remove();
        resizeArray.print();
        resizeArray.remove();
        resizeArray.print();


    }
}
