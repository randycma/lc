import ctcicommon.BSTNode;

public class MinimalTree {

	public static BSTNode<Integer> minimalTree(int[] arr)
	{
		if(arr == null)
		{
			return null;
		}
		
		return helper(arr, 0, arr.length);
	}
	
	public static BSTNode<Integer> helper(int[] arr, int leftIdx, int rightIdx)
	{
		int midIdx = (rightIdx + leftIdx) / 2;
		BSTNode<Integer> node = new BSTNode<Integer>(arr[midIdx]);
		
		if(midIdx - leftIdx > 0)
		{
			node.left = helper(arr, leftIdx, midIdx);
		}
		
		if(rightIdx - (midIdx + 1) > 0)
		{
			node.right = helper(arr, midIdx + 1, rightIdx);			
		}
		
		return node;
	}

	public static void main(String[] args) 
	{
		// BSTNode<Integer> root = minimalTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12});
		BSTNode<Integer> root = minimalTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15, 100});
		BSTNode.printNode(root);
	}

}
