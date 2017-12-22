import ctcicommon.LinkedListNode;


public class Intersection {

	public static LinkedListNode findIntersectionIfLengthsEqual(LinkedListNode head1, LinkedListNode head2)
	{
		while(head1 != null && head2 != null)
		{
			if(head1 == head2)
			{
				return head1;
			}
			
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}
	
	
	
	public static LinkedListNode findIntersection(LinkedListNode head1, LinkedListNode head2)
	{
		if(head1 == null || head2 == null)
		{
			return null;
		}
		
		// Find length of each list, and also compare the final node to see if they are the same
		int len1 = 1;
		LinkedListNode it1 = head1;

		while(it1.next != null)
		{
			len1++;
			it1 = it1.next;
		}	
		
		
		int len2 = 1;
		LinkedListNode it2 = head2;
		while(it2.next != null)
		{
			len2++;
			it2 = it2.next;
		}
		
		if(it1 == it2) // they should be pointing to the ends of head1 and head2
		{
			// They share the same end node, so there must be an intersection.
			// Find the longer list and iterate by the difference in length
			// and pass the two lists of now-equal lengths to findIntersectionIfLengthsEqual
			it1 = head1;
			it2 = head2;
			
			for(int i=0; i < (len1-len2); ++i)
			{
				it1 = it1.next;
			}
			
			for(int i=0; i < (len2-len1); ++i)
			{
				it2 = it2.next;
			}
			
			return findIntersectionIfLengthsEqual(it1, it2);
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
