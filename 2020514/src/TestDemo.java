/*
 * @program: 2020514
 * @description
 * 括号匹配
 * @author: mrs.yang
 * @create: 2020 -05 -15 13 :23
 */

import java.util.Stack;

public class TestDemo {
    public static boolean isMatch(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
         char ch=s.charAt(i);
         //先判断i下标元素是否为左括号
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }else{//不是左括号，判断栈是否为空
                if(stack.empty()){//为空
                    System.out.println("右括号多");
                    return false;
                }else{//不为空
                    char ch2=stack.peek();//拿到栈顶元素
                    //判断栈顶元素是否和i匹配
                    if((ch2=='('&&ch==')')||(ch2=='['&&ch==']')||(ch2=='{'&&ch=='}')){
                        System.out.println("左右括号匹配");
                        stack.pop();
                    }else{
                        System.out.println("左右括号不匹配");
                        return false;
                    }
                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多");
            return false;
        }
        return true;
    }
    public static int  func(int N,int[][] trust){
        int[] out=new int[N];
        int[] in=new int[N];
        for (int i=0;i<trust.length;i++) {
            //记录人的编号
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }
        for (int i = 0; i <N; i++) {
            if(out[i]==0&&in[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    }
}
