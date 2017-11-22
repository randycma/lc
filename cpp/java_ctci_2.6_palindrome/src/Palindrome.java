import java.util.Stack;

import ctcicommon.LinkedListNode;



public class Palindrome {
	public static class Result
	{
		LinkedListNode node;
		boolean result;
		
		Result(LinkedListNode n, boolean result)
		{
			this.node = n;
			this.result = result;
		}
	}
	
	
	// O(n) space, O(n) time
	public static boolean palindrome(LinkedListNode head)
	{
		LinkedListNode node = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(node != null)
		{
			stack.push(node.data);
			node = node.next;
		}
		
		// stack contains LL in reverse order now
		while(head != null)
		{
			// compare head to value popped off of stack
			if(head.data != stack.pop())
			{
				return false;
			}
			head = head.next;
		}
		
		return true;
	}
	
	public static boolean palindromeRecursive(LinkedListNode head)
	{
		// get length of LL
		int len = 0;
		LinkedListNode node = head;
		while(node != null)
		{
			node = node.next;
			len++;
		}
		
		Result res = palindromeRecursiveHelper(head, len);
		return res.result;
	}
	
	public static Result palindromeRecursiveHelper(LinkedListNode head, int length)
	{
		if(length == 1)
		{
			return new Result(head.next, true);
		}
		if(length == 2)
		{
			if(head.data == head.next.data)
			{
				return new Result(head.next.next, true);
			}
			else
			{
				return new Result(head.next.next, false);
			}
		}
		
		Result res = palindromeRecursiveHelper(head.next, length - 2);
		
		if(!res.result)
		{
			return res; // no more comparison needed, just bubble the false to the top stack
		}
		
		if(head.data == res.node.data)
		{
			return new Result(res.node.next, true);
		}
		else
		{
			return new Result(res.node.next, false);
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		
		LinkedListNode node = head;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(5);
		node = node.next;
		
		node.next = new LinkedListNode(2);
		node = node.next;
		
		node.next = new LinkedListNode(1);
		node = node.next;
		

		System.out.println(head.printForward());
		System.out.println(palindrome(head));

		System.out.println(palindromeRecursive(head));
	}

}
