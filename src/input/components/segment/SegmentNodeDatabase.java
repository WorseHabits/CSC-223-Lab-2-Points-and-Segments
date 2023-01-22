package input.components.segment;

import java.util.Arrays;
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
	
	// the adjacency map has each segment twice, so to get the actual number of segments, you should take half
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
		// if the adjacency map doesn't have either point, you have to put both in
		// their adjacency lists only contain each other
		if (!_adjLists.containsKey(a) && !_adjLists.containsKey(b)) {
			_adjLists.put(a, new HashSet<PointNode>(Arrays.asList(b)));
			_adjLists.put(b, new HashSet<PointNode>(Arrays.asList(a)));
		}
		// if it contains the first point but not the second
		// you need to add the second point to the adjacency list for the first point
		// and add the second point to the map
		else if (!_adjLists.containsKey(a) && _adjLists.containsKey(b)) {
			Set<PointNode> aADJ = new HashSet<PointNode>(_adjLists.get(a));
			aADJ.add(b);
			_adjLists.put(a, aADJ);
			_adjLists.put(b, new HashSet<PointNode>(Arrays.asList(a)));
		}
		// if it contains the second point but not the first
		// you need to add the first point to the adjacency list for the second point
		// and add the first point to the map
		else if (!_adjLists.containsKey(a) && _adjLists.containsKey(b)) {
			Set<PointNode> bADJ = new HashSet<PointNode>(_adjLists.get(b));
			bADJ.add(a);
			_adjLists.put(b, bADJ);
			_adjLists.put(a, new HashSet<PointNode>(Arrays.asList(b)));
		}
		// if the adjacency map already contains both points, you shouldn't do anything
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
