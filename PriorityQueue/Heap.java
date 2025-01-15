package PriorityQueue;
import java.util.*;
public class heap {
    private ArrayList<Integer>ll = new ArrayList<>();

    public void add(int item){
        ll.add(item);
        upheapify(ll.size()-1);
    }

    private void  upheapify(int ci){
        int pi = (ci-1)/2;

        if(ll.get(pi)>ll.get(ci)){
            swap(pi,ci);
            upheapify(pi);
        }
    }

    public void swap(int pi, int ci){
        int t = ll.get(pi);
        ll.set(pi,ll.get(ci));

        ll.set(ci,t);
    }

    public int remove(){
        swap(0,ll.size()-1);
        int rv = ll.remove(ll.size()-1);
        downheapify(0);
        return rv;

    }

    public void downheapify(int pi){
        int lci = 2*pi+1;
        int rci = 2*pi+2;

        int mini = pi;

        if(ll.get(mini)>ll.get(lci))
            mini=lci;
        
        if(ll.get(mini)>ll.get(rci))
            mini=rci;

        if(mini != pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }


    public int get(){
        return ll.get(0);
    }

    public void display(){
        System.out.println(ll);
    }
}
