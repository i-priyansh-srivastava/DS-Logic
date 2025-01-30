package impli_tree;
// INPUT TYPE--> 10 true 20 true 40 false false true 100 false false true 50 false false
import java.util.Scanner;

public class implimentation {
    class Node{
        int val;
        Node left;
        Node right;
    }

    private Node root;

    public implimentation(){
        root = CreateTree();
    }

    Scanner sc= new Scanner(System.in);
    private Node CreateTree(){
        int item=sc.nextInt();
        Node nn =new Node();
        nn.val=item;
        boolean hlc = sc.nextBoolean();
        if(hlc){
            nn.left=CreateTree();
        }
        boolean hrc = sc.nextBoolean();
        if(hrc){
            nn.right=CreateTree();
        }

        return nn;
    }

    public void Display(){
        Display(root);
    }

    private void Display(Node node){
        if(node == null)
            return;
        String s="";
        s= "<--" + node.val + "-->";

        if(node.left != null){
            s=node.left.val + s;
        }
        else
            s= "."+s;

        if(node.right!=null)
            s=s+node.right.val;
        else
            s=s+".";
        
        System.out.println(s);
        Display(node.left);
        Display(node.right);

    }

    public int max(){
        return max(root);
    }

    public int max(Node node){
        if(node == null)
            return Integer.MIN_VALUE;

        int left = max(node.left);
        int right = max(node.right);

        return Math.max(left, Math.max(right, node.val));

    }

    public boolean isPresent(int find){
        return isPresent(root, find);
    }

    private boolean isPresent(Node root, int find){
        if(root == null)
            return false;
        if(root.val == find){
            return true;
        }
        
        return isPresent(root.left, find) || isPresent(root.right, find);

    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        int left=height(root.left);
        int right=height(root.right);

        return Math.max(left, right)+1;

    }

    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void preOrder(Node root){
        if(root == null)
            return ;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root){
        if(root == null)
            return ;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    private void postOrder(Node root){
        if(root == null)
            return ;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
