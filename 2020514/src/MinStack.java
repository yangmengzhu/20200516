/*
 * @program: 2020514
 * @description
 * 最小栈
 * @author: mrs.yang
 * @create: 2020 -05 -15 14 :27
 */

import java.util.Stack;

public class MinStack {
       public Stack<Integer> stack;
       public Stack<Integer> minStack;

        public MinStack() {
            this.stack=new Stack<>();
            this.minStack=new Stack<>();
        }
        //入栈
        public void push(int x) {
            this.stack.push(x);
          if(this.minStack.empty()){
              this.minStack.push(x);
          }else{
              int tmp=this.stack.peek();
              if(tmp<=this.minStack.peek()){
                  this.minStack.push(x);
              }
          }
        }
         //出栈
        public void pop() {
          if(!this.stack.empty()){
              int tmp=this.stack.pop();
              if(tmp==this.minStack.peek()){
                  this.minStack.pop();
              }
          }
        }

        public int top() {
          if(this.stack.empty()){
              return -1;
          }
          return this.stack.peek();
        }

        public int getMin() {
          if(this.minStack.empty()){
              return -1;
          }
          return this.minStack.peek();
        }

}
