package stack;

import java.util.Stack;

public class stackReverse {
    public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(450);
		st.push(560);
		System.out.println(st);
		Reverse(st);
		System.out.println(st);
	}
	public static void Reverse(Stack<Integer> st) {
		if (st.isEmpty()) {
			return;
		}
		int x = st.pop();
		Reverse(st);
		Insert(st, x);
	}
	public static void Insert(Stack<Integer> st, int item) {
		if (st.isEmpty()) {
			st.push(item);
			return;
		}
		int x = st.pop();
		Insert(st, item);
		st.push(x);
	}
}
