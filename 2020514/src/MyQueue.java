/*
 * @program: 2020514
 * @description
 * 两个栈实现队列==》先进的先出
 * @author: mrs.yang
 * @create: 2020 -05 -15 16 :36
 */

import java.util.Stack;

public class MyQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public MyQueue(){
        this.stack1=new Stack<>();
        this.stack2=new Stack<>();
    }
    public void push(int x) {
     //入队都入到1中
        this.stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()){
            return -1;
        }
        if(this.stack2.empty()){//2中没有
          while(!this.stack1.empty()) {
              this.stack2.push(this.stack1.pop());
          }
       }
         return this.stack2.pop();

    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return -1;
        }
        if(this.stack2.empty()){//2中没有,1有
            while(!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        //2中有，直接出2
        return this.stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack1.empty()&& this.stack2.empty();
    }
}
