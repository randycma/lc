import ctcicommon.BSTNode;

public class CheckBalanced {

	public static class ReturnValue
	{
		int height;
		boolean isBalanced;
	}
	
	public static boolean checkBalanced(BSTNode<Integer> root)
	{
		ReturnValue ret = getHeight(root);
		
		return ret.isBalanced;
	}
	
	// TODO: Instead of using ReturnValue, we can just use an "error code" like Integer.MIN_VALUE
	public static ReturnValue getHeight(BSTNode<Integer> root)
	{
		ReturnValue ret = new ReturnValue();
		if(root == null)
		{
			ret.height = 0;
			ret.isBalanced = true;
			return ret;
		}

		int rightHeight = 0;
		int leftHeight = 0;
		boolean isBalanced = true;
		
		if(root.left != null)
		{
			ReturnValue leftRet = getHeight(root.left);
			isBalanced &= leftRet.isBalanced;
			leftHeight = leftRet.height;
		}
		if(root.right != null)
		{
			ReturnValue rightRet = getHeight(root.right);
			isBalanced &= rightRet.isBalanced;
			rightHeight = rightRet.height;
		}
		
		ret.height = 1 + Math.max(leftHeight, rightHeight);
		isBalanced &= (Math.abs(rightHeight - leftHeight) <= 1);
		ret.isBalanced = isBalanced;
		
		return ret;
	}
	
	public static void main(String[] args) {
		BSTNode<Integer> root = new BSTNode<Integer>(1);
		root.left = new BSTNode<Integer>(2);
//		root.right = new BSTNode<Integer>(3);
		
		root.left.left = new BSTNode<Integer>(4);
		root.left.right = new BSTNode<Integer>(5);
		
//		root.right.left = new BSTNode<Integer>(6);
//		root.right.right = new BSTNode<Integer>(7);
		
		BSTNode.printNode(root);
		
		System.out.println(checkBalanced(root));
	}

}
