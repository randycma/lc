import java.util.HashSet;
import java.util.LinkedList;

import ctcicommon.LinkedListNode;

public class RemoveDuplicates {

	public static void removeDuplicates(LinkedListNode e)
	{
		if(e == null)
			return;
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(e.data); // first node can't be a dupe;
		
		LinkedListNode node = e;
		while(node.next != null)
		{
			if(set.contains(node.next.data))
			{
				// skip over next node since it's a duplicate
				node.next = node.next.next;
			}
			else
			{
				set.add(node.next.data);
				node = node.next;
			}
		}
	}
	
	public static void removeDuplicatesNoBuffer(LinkedListNode e)
	{
		if(e == null)
			return;
		
		// Iterate through from this node to end, removing node if it's equal to current node
		LinkedListNode node = e;
		while(node.next != null)
		{
			if(e.data == node.next.data)
			{
				node.next = node.next.next;
			}
			else
			{
				node = node.next;
			}
		}
		
		removeDuplicatesNoBuffer(e.next);
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		
		LinkedListNode node = head;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(3);
		node = node.next;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(3);
		node = node.next;
		
		node.next = new LinkedListNode(4);
		node = node.next;
		
		node.next = new LinkedListNode(6);
		node = node.next;
		
		node.next = new LinkedListNode(1);
		node = node.next;
		
		
		System.out.println(head.printForward());
//		removeDuplicates(head);
		removeDuplicatesNoBuffer(head);
		System.out.println(head.printForward());
	}

}
