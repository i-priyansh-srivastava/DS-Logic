package GRAPH;

import java.util.*;

public class Graph {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int v) {
        map = new HashMap<>();
        for (int i = 0; i <= v; i++)
            map.put(i, new HashMap<>());
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);

    }

    public boolean containsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }

    public boolean containsVertex(int v1) {
        return map.containsKey(v1);
    }

    public int noOfEdge(int v1) {
        int ans = 0;
        for (int vtx : map.keySet())
            ans += map.get(vtx).size();

        return ans / 2;
    }

    public void removeEdge(int v1, int v2) {
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v1) {
        for (int nghrs : map.get(v1).keySet()) {
            map.remove(nghrs, v1);
        }

        map.remove(v1);
    }

    public void display() {
        for (int vtx : map.keySet()) {
            System.out.println(map.get(vtx));
        }
    }

    public boolean hasPath(int src, int des, HashSet<Integer> visited) {
        if (src == des)
            return true;
        visited.add(src);
        for (int n : map.get(src).keySet()) {
            if (!visited.contains(n))
                if (hasPath(n, des, visited))
                    return true;
        }
        return false;
    }

    public void PrintPath(int src, int des, HashSet<Integer> visited, String ans) {
        if (src == des) {
            System.out.println(ans + "->" + des);
            return;
        }
        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                PrintPath(nbrs, des, visited, ans + "->" + src);
            }
        }
        visited.remove(src);
    }

    public boolean BFS(int src, int des){
        Queue<Integer>qu = new LinkedList<>();
        qu.add(src);
        HashSet<Integer> visited = new HashSet<>();
        while(!qu.isEmpty()){
            // 1. Remove
            int rv = qu.poll();
             // 2. Ignore if already visited
            if(visited.contains(rv))
                continue;
            // 3. pick visited
            visited.add(rv);

            // 4. Operations
            if(rv == des)
                return true;
            
            // 5. Add unvisited neighbours
            for(int nbrs: map.get(rv).keySet()){
                if(!visited.contains(nbrs))
                    qu.add(nbrs);
            }
            
        }
        return false;
    }


    public boolean DFS(int src,int des){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            int rv=q.poll();
            if(visited.contains(rv)){
                continue;
            }
            visited.add(rv);
            if(rv==des){
                return true;
            }
            for(int nbrs:map.get(rv).keySet()){
                if(!visited.contains(nbrs)) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }


    public boolean BFT(int des){
        Queue<Integer>qu = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int src: map.keySet()){
            if(visited.contains(src))
                continue;

            qu.add(src);
            
            while(!qu.isEmpty()){
                // 1. Remove
                int rv = qu.poll();
                // 2. Ignore if already visited
                if(visited.contains(rv))
                continue;
                // 3. pick visited
                visited.add(rv);
                
                // 4. Operations
                if(rv == des)
                return true;
                
                // 5. Add unvisited neighbours
                for(int nbrs: map.get(rv).keySet()){
                    if(!visited.contains(nbrs))
                    qu.add(nbrs);
                }
                
            }
        }
        return false;
    }
}
