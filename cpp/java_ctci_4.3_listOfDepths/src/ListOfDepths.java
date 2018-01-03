import ctcicommon.*;
import java.util.*;


public class ListOfDepths {

	public static ArrayList<LinkedList<BSTNode<Integer>>> listOfDepths(BSTNode<Integer> root)
	{
//		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		ArrayList<LinkedList<BSTNode<Integer>>> result = new ArrayList<LinkedList<BSTNode<Integer>>>();
		
		TreeMap<Integer, BSTNode<Integer>> depthToNode = new TreeMap<Integer, BSTNode<Integer>>();
		helper(root, 0, depthToNode);
		
		for(Map.Entry<Integer, BSTNode<Integer>> entry : depthToNode.entrySet())
		{
			if(result.size() == entry.getKey()) // we iterate in order so this is ok
			{
				result.add(new LinkedList<BSTNode<Integer>>());
			}
			result.get(entry.getKey()).add(entry.getValue());
		}
		return result;
	}
	
	public static void helper(BSTNode<Integer> node, int depth, Map<Integer, BSTNode<Integer>> depthToNode)
	{
		depthToNode.put(depth, node);
		if(node.left != null)
			helper(node.left, depth+1, depthToNode);
		if(node.right != null)
			helper(node.right, depth+1, depthToNode);
	}
	
	public static void main(String[] args) {
		
	}

}
