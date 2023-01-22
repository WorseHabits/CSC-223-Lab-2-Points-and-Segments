package input.components.segment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import input.components.point.PointNode;

public class SegmentNodeDatabase {
	
	private Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase() {
		
		_adjLists = new HashMap<PointNode, Set<PointNode>>();
		
	}
	
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> adjLists) {
		
		_adjLists = new HashMap<PointNode, Set<PointNode>>(adjLists);
		
	}
	
	public int numUndirectedEdges() {
		
		int total = 0;
		
		for (Set<PointNode> adjacencies : _adjLists.values()) {
			
			total = total + adjacencies.size();
			
		}
		
		return total / 2;
	}
	
	public void addDirectedEdge(PointNode a, PointNode b) {
		
		
	}
	
	public void addUndirectedEdge(PointNode a, PointNode b) {
		
		if (!_adjLists.containsKey(a) && !_adjLists.containsKey(b)) {
			
		}
		
	}
	
	public void addAjacencyList(PointNode point, List<PointNode> adjList) {
		
	}
	
	public List<SegmentNode> asSegmentList() {
		
		return null;
		
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		
		return null;
		
	}
}
