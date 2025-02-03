package GRAPH;
import java.util.*;
public class Kruskal {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public KruskalAlgo(int v) {
        map = new HashMap<>();
        for (int i = 0; i <= v; i++)
            map.put(i, new HashMap<>());
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);

    }

    class EdgePair{
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1, int e2, int cost){
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
    }

    public List<EdgePair> getAllEdge(){
        List<EdgePair> ll = new ArrayList<>();
        for(int e1:map.keySet()){
            for(int e2:map.keySet()){
                int cost = map.get(e1).get(e2);
                ll.add(new EdgePair(e1, e2, cost));
            }
        }

        return ll;
    }

    public void KruskalsAlgo(){
        List<EdgePair> ll = getAllEdge();
        Collections.sort(ll,new Comparator<EdgePair>(){
            @Override
            public int compare(EdgePair o1, EdgePair o2){
                return o1.cost - o2.cost;
            }
        });

        DisjointSet dsu = new DisjointSet();
        for(int v: map.keySet()){
            dsu.Create(v);
        }

        int ans =0;
        for(EdgePair e: ll){
            int re1 = dsu.find(e.e1);
            int re2 = dsu.find(e.e2);

            if(re1 == re2){

            }
            else{
                dsu.union(re1, re2);
                ans += e.cost;
            }
        }
        System.out.println(ans);

    }
}
