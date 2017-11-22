import ctcicommon.LinkedListNode;

public class Partition {

	public static LinkedListNode partition(LinkedListNode head, int x)
	{
		LinkedListNode lessThan = null;
		LinkedListNode lessThanEnd = null;
		
		LinkedListNode greaterThan = null;
		LinkedListNode greaterThanEnd = null;
		
		while(head != null)
		{
			if(head.data < x)
			{
				if(lessThanEnd != null) {
					lessThanEnd.next = head;
					lessThanEnd = lessThanEnd.next;
				}
				else {
					lessThan = head;
					lessThanEnd = lessThan;
				}
			}
			else
			{
				if(greaterThanEnd != null) {
					greaterThanEnd.next = head;
					greaterThanEnd = greaterThanEnd.next;
				}
				else {
					greaterThan = head;
					greaterThanEnd = greaterThan;
				}
			}
			head = head.next;
		}
		if(lessThanEnd == null) {
			return greaterThan;
		}
		
		lessThanEnd.next = greaterThan;
		return lessThan;
	}
	
	
	public static LinkedListNode partition2(LinkedListNode head, int x) {
		// use two nodes to mark start and end of new list.
		// iterate through the LL and if data < x, then add it to start, otherwise add it to end
		LinkedListNode start = head;
		LinkedListNode end = head;
		
		while(head != null)
		{
			LinkedListNode next = head.next; // need to store because we are changing head.next
			if (head.data < x) {
				// add element to start
				head.next = start;
				start = head;
			}
			else {
				end.next = head;
				end = end.next;
			}
			head = next;
		}
		return start;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(3);
		
		LinkedListNode node = head;
		
		node.next = new LinkedListNode(5);
		node = node.next;
		
		node.next = new LinkedListNode(8);
		node = node.next;
		
		node.next = new LinkedListNode(5);
		node = node.next;
		
		node.next = new LinkedListNode(10);
		node = node.next;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(1);
		node = node.next;
		
		node.next = new LinkedListNode(8);
		node = node.next;
		
		System.out.println(head.printForward());
		System.out.println(partition2(head,5).printForward());

	}

}
