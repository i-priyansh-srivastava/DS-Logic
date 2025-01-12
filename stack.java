package stack;

public class stack {
    private int[]arr;
    private int idx;

    public stack(){
        arr=new int[5];
    }

    public stack(int n){
        arr=new int[n];
    }

    public boolean isEmpty(){
        return idx==0;
    }
    public boolean isFull(){
        return arr.length==idx;
    }

    public int size(){
        return idx;
    }

    public void push (int item) throws Exception{
        if(isFull()){
            throw new Exception("Error:-Stack is full");
        }
        arr[idx]=item;
        idx++;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Error:-Stack is Empty");
        }
        idx--;
        return arr[idx];
    }

    public int peek(){
        return arr[idx-1];
    }

    public void Display(){
        for(int i=0;i<idx;i++){
            System.out.println(arr[i]+" ");
        }
    }
  
}
