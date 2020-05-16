import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *
 * @program: 2020514
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -15 20 :10
 */
class Node {
    public char val;
    public Node left;//左孩子-》左子树
    public Node right;//右孩子-》右子树
    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {

    public Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 前序遍历   递归来实现
    List<String> preOrderTraversal(Node root){
        List<String> list=new ArrayList<>();
        if(root == null) {
            return list;
        }
        System.out.print(root.val+" ");
        list.add(root.val+" ");
        List<String> left=preOrderTraversal(root.left);
        list.addAll(left);
        List<String> right=preOrderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    // 中序遍历
    void inOrderTraversal(Node root){
     if(root==null){
         return;
     }
        inOrderTraversal(root.left);
        System.out.println(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val+" ");
    }
    static int size=0;
    public int getSize1(Node root){
        if(root==null){
            return 0;
        }
        System.out.println(root.val+" ");
        size++;
        getSize1(root.left);
        getSize1(root.right);
        return size;
    }

    public int getSize2(Node root){
        if(root==null){
            return 0;
        }
        return getSize2(root.left)+getSize2(root.right)+1;
    }
    static int size1=0;
    public int getLeaves(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            size1++;
        }else{
            getLeaves(root.left);
            getLeaves(root.right);
        }
        return size1;
    }
    /*public int getLeaves(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeaves(root.left)+getLeaves(root.right);
    }*/

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        Node root= binaryTree.buildTree();
        binaryTree.inOrderTraversal(root);
       System.out.println();
        System.out.println(binaryTree.getSize2(root));
        System.out.println(binaryTree.getLeaves(root));
        System.out.println(binaryTree.getLeaves(root));
    }
}

