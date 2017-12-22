import java.util.LinkedList;

import ctcicommon.*;

public class RouteBetweenNodes {

	public static boolean FindRouteBetweenNodesBFS(GraphNode origin, GraphNode destination)
	{
		LinkedList<GraphNode> q = new LinkedList<GraphNode>(); 
		
		origin.visited = true;
		q.add(origin);
		
		while(!q.isEmpty())
		{
			GraphNode node = q.pop();
			System.out.println("visiting " + node.name);
			if(node == destination) return true;
			node.visited = true;
			for(GraphNode c : node.vertices)
			{
				if(c.visited != true)
				{
					q.add(c);
				}
			}
		}
		return false;
	}
	
	
	public static boolean FindRouteBetweenNodesDFS(GraphNode origin, GraphNode destination)
	{
		LinkedList<GraphNode> q = new LinkedList<GraphNode>(); 
		
		origin.visited = true;
		q.addFirst(origin);
		
		while(!q.isEmpty())
		{
			GraphNode node = q.pop();
			System.out.println("visiting " + node.name);
			if(node == destination) return true;
			node.visited = true;
			for(GraphNode c : node.vertices)
			{
				if(c.visited != true)
				{
					q.addFirst(c);
				}
			}
		}
		return false;
	}
	
	public static boolean FindRouteBetweenNodesDFSRecursive(GraphNode origin, GraphNode destination)
	{
		origin.visited = true;
		if(origin == destination)
			return true;
		boolean result = false;
		for(GraphNode n : origin.vertices)
		{
			if(n.visited != true)
			{
				result |= FindRouteBetweenNodesDFSRecursive(n, destination);
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		GraphNode f = new GraphNode("f");
		
		a.addVertex(b); a.addVertex(f);
		
		b.addVertex(d); b.addVertex(e);
		
		c.addVertex(b);
		
		d.addVertex(c); d.addVertex(e);
		
		System.out.println(FindRouteBetweenNodesDFSRecursive(d, e));
	}

}
