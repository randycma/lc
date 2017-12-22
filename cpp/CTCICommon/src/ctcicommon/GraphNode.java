package ctcicommon;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphNode {
	public String name;
	public ArrayList<GraphNode> vertices;
	public boolean visited = false;

	
	public GraphNode()
	{
		this("");
	}
	
	public GraphNode(String name)
	{
		this(name, new GraphNode[0]);
	}
	
	public GraphNode(String name, GraphNode[] vertices)
	{
		this(name, new ArrayList<GraphNode>(Arrays.asList(vertices)));
	}
	
	public GraphNode(String name, ArrayList<GraphNode> vertices)
	{
		this.name = name;
		this.vertices = vertices;
	}
	
	public void addVertex(GraphNode vertex)
	{
		vertices.add(vertex);
	}
}
