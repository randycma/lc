import ctcicommon.BSTNode;

public class MinimalTree {

	public static BSTNode<Integer> minimalTree(int[] arr)
	{
		if(arr == null)
		{
			return null;
		}
		
		BSTNode<Integer> root = new BSTNode<Integer>(Integer.MIN_VALUE);
		
		minimalTreeHelper(arr, 0, arr.length, root);
		
		return root;
	}
	
	public static void minimalTreeHelper(int[] arr, int leftIdx, int rightIdx, BSTNode<Integer> node)
	{
		// Find midpt
		int midIdx = (rightIdx + leftIdx) / 2;
		node.data = arr[midIdx];
		
		if(midIdx - leftIdx > 0)
		{
			node.left = new BSTNode<Integer>(Integer.MIN_VALUE);
			minimalTreeHelper(arr, leftIdx, midIdx, node.left);
		}
		
		if(rightIdx - (midIdx + 1) > 0)
		{
			node.right = new BSTNode<Integer>(Integer.MIN_VALUE);
			minimalTreeHelper(arr, midIdx + 1, rightIdx, node.right);			
		}
	}

	public static void main(String[] args) 
	{
		BSTNode<Integer> root = minimalTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12});
		BSTNode.printNode(root);
	}

}
