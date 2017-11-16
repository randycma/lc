import ctcicommon.LinkedListNode;

public class DeleteMiddleNode {
	
	public static void deleteMiddleNode(LinkedListNode nodeToDelete)
	{
		if(nodeToDelete == null)
			return;
		
		if(nodeToDelete.next == null)
			return; // impossible to delete if we're already at the end
		
		nodeToDelete.data = nodeToDelete.next.data;
		nodeToDelete.next = nodeToDelete.next.next;
	}
	
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
		deleteMiddleNode(head.next.next);
		System.out.println(head.printForward());

	}

}
