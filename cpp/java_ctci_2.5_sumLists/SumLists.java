import ctcicommon.LinkedListNode;

public class SumLists {

	public static LinkedListNode sumListsBackwards(LinkedListNode a, LinkedListNode b)
	{
		int carry = 0;
		LinkedListNode retHead = null;
		LinkedListNode retEnd = null;
		while(a != null || b != null || carry != 0)
		{
			int digitSum = carry;
			if(a != null)
			{
				digitSum += a.data;
				a = a.next;
			}
			
			if(b != null)
			{
				digitSum += b.data;
				b = b.next;
			}
			
			carry = digitSum/10;
			digitSum %= 10;
			
			if(retEnd != null)
			{
				retEnd.next = new LinkedListNode(digitSum);
				retEnd = retEnd.next;
			}
			else
			{
				retHead = new LinkedListNode(digitSum);
				retEnd = retHead;
			}
		}
		
		return retHead;
	}
	
	public static void sumListsForward(LinkedListNode a, LinkedListNode b)
	{
		// TODO
	}
	
	public static void main(String[] args) {
		LinkedListNode a = new LinkedListNode(9);
		
		LinkedListNode node = a;
		
		node.next = new LinkedListNode(7);
		node = node.next;
		
		node.next = new LinkedListNode(8);
		node = node.next;
		
		LinkedListNode b = new LinkedListNode(6);
		node = b;
		
		node.next = new LinkedListNode(8);
		node = node.next;
		
		node.next = new LinkedListNode(5);
		node = node.next;
		
		System.out.println(a.printForward());
		System.out.println(b.printForward());
		System.out.println(sumListsBackwards(a, b).printForward());


	}
	
}

