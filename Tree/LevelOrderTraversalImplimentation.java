package impli_tree;
import java.util.*;
    
    public class createTreeByLvlTraverrsal {
        class Node{
            int val;
            Node left;
            Node right;
        }
        Scanner sc = new Scanner(System.in);
        public void Create_Tree(){
            int item=sc.nextInt();
            Node nn = new Node();
            nn.val=item;
            Node rn=nn;
            Queue<Node> q = new LinkedList<>();
            q.add(nn);
            while(!q.isEmpty()){
                Node temp = q.poll();
                int c1=sc.nextInt();
                int c2=sc.nextInt();
                if(c1!=-1){
                    Node node=new Node();
                    node.val=c1;
                    temp.left=node;
                    q.add(node);
                }
                if(c2!=-1){
                    Node node=new Node();
                    node.val=c2;
                    temp.right=node;
                    q.add(node);
                }
            }
        }
    }
