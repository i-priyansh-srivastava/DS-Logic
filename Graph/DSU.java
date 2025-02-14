package GRAPH;

import java.util.HashMap;

public class DisjointSet {
    class Node{
        int vtx;
        int rank;
        Node parent;
    }

    private HashMap<Integer, Node> map= new HashMap<>();
    
    public void Create(int v){
        Node nn = new Node();
        nn.vtx = v;
        nn.rank= 0;
        nn.parent = nn;
        map.put(v, nn);
    }

    public int find(int v){
        Node nn = map.get(v);
        return find(nn).vtx;
    }

    public Node find(Node nn){
        if(nn.parent == nn)
            return nn;
        
        Node n = find(nn.parent);
        nn.parent = n; //path compression --> mapping each child node to its ultimate parent node
        return n;
    }

    public void union(int v1, int v2){
        Node n1 = map.get(v1);
        Node n2 = map.get(v2);
        Node rn1 = find(n1);
        Node rn2 = find(n2);

        // union by rank
        if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }

        else if(rn1.rank < rn2.rank){
            rn2.parent = rn1;
        }

        else{
            rn1.parent = rn2.parent;
            rn1.rank = rn1.rank+1;
        }
    }
}
