package tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//collections framework
//list interface
class CollectionTutorial {

	// arraylist
	public void Arraylist_t() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(0, 45);
		System.out.println(al);
		System.out.println(al.get(2));
		System.out.println(al.isEmpty());
		System.out.println(al.contains(2));
		al.remove(0);
		System.out.println(al);
		// iterating thé arraylist
		// 1st method
		System.out.println("Iterating the lsit :");
		for (int a : al) {
			System.out.println(a);
		}
		// 2nd method
		System.out.println("Iterating using the Iterator :");
		Iterator<Integer> it = al.iterator();
		System.out.println(it);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println(al.size());
		System.out.println(al.toString());
	}

	// stack tutorial
	public void Stack_t() {
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st);
		System.out.println(st.capacity());
		System.out.println(st.size());
		System.out.println(st.empty());
		System.out.println(st.peek()); // returns the last inserted element
		System.out.println(st.pop()); // returns the last inserted element and removes it from the stack
		System.out.println(st);
		Iterator<Integer> it = st.iterator();
		System.out.println(it);
	}

	// linkedlist
	public void LinkedList_t() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		System.out.println(ll);
		ll.offer(3);
		System.out.println(ll);
		System.out.println(ll.peek()); // returns the first element from the list
		System.out.println(ll.peekLast()); // returns the last element from the list
		System.out.println(ll.peekFirst()); // same as peek()
		System.out.println(ll.offerFirst(5)); // adds the element in the begining of the list
		System.out.println(ll);
		System.out.println(ll.offerLast(6)); // adds the element in the last of the list.
		System.out.println(ll);
		System.out.println(ll.poll()); // removes the first element from the list and returns the element to be deleted
		System.out.println(ll);
		System.out.println(ll.pollFirst()); // same as poll
		System.out.println(ll);
		System.out.println(ll.pollLast()); // removes the last element from the stack and returns the element to be
											// deleted
		System.out.println(ll);
	}

	//
}

public class Tut36 {

	public static void main(String[] args) {
		CollectionTutorial ct = new CollectionTutorial();
//		ct.Arraylist_t();
//		ct.Stack_t();
		ct.LinkedList_t();
		
		//you can reference to other tutorial in web available on the web or else documentation for more
		// there are map interface ,set interface, list interface
	}

}
