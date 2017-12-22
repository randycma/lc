import ctcicommon.LinkedListNode;

public class LoopDetection {

	
	// Detect loop and return start of loop
	public static LinkedListNode detectLoop(LinkedListNode head)
	{
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
		{
			return null; // no collision, we simply got to the end of the LL
		}
		
		// At this point, the two pointers have collided and are K nodes from the start of loop,
		// where K is the number of nodes before the loop begins.
		// Move one of the pointers back to head and iterate both at the sam etime
		
		slow = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
