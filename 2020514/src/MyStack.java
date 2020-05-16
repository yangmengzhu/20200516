/*
 * @program: 2020514
 * @description
 * 两个队列实现栈
 * @author: mrs.yang
 * @create: 2020 -05 -15 15 :53
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;
    public MyStack(){
        this.queue1=new LinkedList<>();
        this.queue2=new LinkedList<>();
    }
    public void push(int x) {
        //哪个不为空入哪个，两个都不为空，入queue1
     if(this.queue1.isEmpty() && this.queue2.isEmpty()){
         this.queue1.offer(x);
     }else{
         if(!this.queue1.isEmpty()){
             this.queue1.offer(x);
         }else{
             this.queue2.offer(x);
         }
     }
    }
    public int pop() {
     if(empty()){
         return -1;
     }
     //哪个不为空就出 n-1ge哪个的元素
        int size1=this.queue1.size();
        int size2=this.queue2.size();
        int val=0;
        if(!this.queue1.isEmpty()){
            for (int i = 0; i < size1-1; i++) {
                this.queue2.offer(this.queue1.poll());
            }
            val=this.queue1.poll();
        }else {
            for (int i = 0; i < size2 - 1; i++) {
                this.queue1.offer(this.queue2.poll());
            }
            val=this.queue2.poll();
        }
        return val;
    }
    public int top() {
     if(empty()){
         return -1;
     }
        int size1=this.queue1.size();
        int size2=this.queue2.size();
        int val=0;
        if(!this.queue1.isEmpty()){
            for (int i = 0; i < size1; i++) {
                val=this.queue1.poll();
                this.queue2.offer(val);
            }
        }else {
            for (int i = 0; i < size2; i++) {
                val=this.queue2.poll();
                this.queue1.offer(val);
            }
        }
        return val;
    }
    public boolean empty() {
     return this.queue1.isEmpty()&&this.queue2.isEmpty();
    }
}
