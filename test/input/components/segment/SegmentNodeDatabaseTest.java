package input.components.segment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import input.components.PointNode;

class SegmentNodeDatabaseTest
{
    public SegmentNodeDatabase build()
    {
    	//      A                                 
    	//     / \                                
    	//    B___C                               
    	//   / \ / \                              
    	//  /   X   \ 
    	// D_________E
    	//
		//
    	PointNode a = new PointNode("A", 3, 6);
    	PointNode b = new PointNode("B", 2, 4);
    	PointNode c = new PointNode("C", 4, 4);

    	PointNode d = new PointNode("D", 0, 0);
    	PointNode e = new PointNode("E", 6, 0);
    	PointNode x = new PointNode("X", 3, 3);

    	SegmentNodeDatabase db = new SegmentNodeDatabase();
    	  	
    	db.addUndirectedEdge(a, b);
    	db.addUndirectedEdge(a, c);
    	db.addUndirectedEdge(b, c);
    	db.addUndirectedEdge(b, x);
    	db.addUndirectedEdge(b, d);
    	db.addUndirectedEdge(c, x);
    	db.addUndirectedEdge(c, e);
    	db.addUndirectedEdge(x, d);
    	db.addUndirectedEdge(x, e);
    	db.addUndirectedEdge(d, e);
    	
    	return db;
    }
 
	@Test
	void testNumUndirectedEdges()
	{
		SegmentNodeDatabase db = build();
		
		assertEquals(10, db.numUndirectedEdges());
	}
	
	@Test
	void testAddAdjacencyList() {
		SegmentNodeDatabase db = build();
		
		PointNode f = new PointNode("F", 6, 6);
		PointNode g = new PointNode("G", 8, 8);
		PointNode a = new PointNode("A", 3, 6);
		PointNode e = new PointNode("E", 6, 0);
		db.addAjacencyList(f, Arrays.asList(a, e, g));
		
		assertEquals(13, db.numUndirectedEdges());
	}
}
