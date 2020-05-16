/*
 * @program: 2020514
 * @description
 * 循环队列（数组）
 * @author: mrs.yang
 * @create: 2020 -05 -15 15 :15
 */

import java.util.Arrays;

public class MyCircularQueue {
    public int[] arr;
    public int front;
    public int rear;
    public MyCircularQueue(int k){
        this.arr=new int[k];//k+1
    }
    public boolean isEmpty() {
     return this.front==this.rear;
    }
    public boolean isFull() {
      return (this.rear+1)%this.arr.length==this.front;
    }
    //入队，
    public boolean enQueue(int value) {
     //判断是否已满,满了不必扩容
        if(isFull()){
           return false;
        }
        this.arr[this.rear]=value;
        this.rear=(this.rear+1)%this.arr.length;
        return true;
    }
    //出队
    public boolean deQueue() {
     if(isEmpty()){
         return false;
     }
     this.front=(this.front +1)%this.arr.length;
     return true;
    }
    public int Front() {
     if(isEmpty()){
         return -1;
     }
     return this.arr[this.front];
    }
    public int rear() {
     if(isEmpty()){
         return -1;
     }
    return this.rear==0 ? this.arr[this.arr.length-1] : this.arr[this.rear-1];
    }

}
