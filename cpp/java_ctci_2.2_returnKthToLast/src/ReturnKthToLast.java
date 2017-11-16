import ctcicommon.LinkedListNode;

public class ReturnKthToLast {

	
	public static LinkedListNode returnKthToLast(LinkedListNode node, int k)
	{
		LinkedListNode kth = node;
		
		boolean atLeastK = false;
		while(node.next != null)
		{
			node = node.next;
			if(k == 1) // if k==1 means returning last element then this would be 1 and not 0
			{
				kth = kth.next;
				atLeastK = true;
			}
			else
				k--;
		}
		
		if(atLeastK)
			return kth;
		return null;
	}
	
	// Use return value as counter; assume we only need to print the value of the node
	public static int returnKthRecursive(LinkedListNode node, int k)
	{
		if(node == null)
		{
			return 0;
		}
		
		int counter = 1 + returnKthRecursive(node.next, k);
		if(k == counter)
		{
			System.out.println(node.data);
		}
		
		return counter;
	}
	
//	public static LinkedListNode returnKthRecursiveHelper(LinkedListNode node, int k, int i)
//	{
//		if(node.next == null)
//			return ;
//		else
//			return returnKthRecursiveHelper(node,  k, i+1);
//	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		
		LinkedListNode node = head;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(3);
		node = node.next;
		
		node.next = new LinkedListNode(4);
		node = node.next;
		
		node.next = new LinkedListNode(5);
		node = node.next;
		
		node.next = new LinkedListNode(6);
		node = node.next;
		
		node.next = new LinkedListNode(7);
		node = node.next;
		
		node.next = new LinkedListNode(8);
		node = node.next;
		
		
		System.out.println(head.printForward());
		System.out.println(returnKthToLast(head, 3).data);
		returnKthRecursive(head, 3);

	}

	
}
