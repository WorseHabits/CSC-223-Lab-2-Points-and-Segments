package input.components.segment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) {
			for (PointNode p : entry.getValue()) {
				total++;
			}
		}
		return total / 2;
	}
	
	// idk what the - means in the lab instructions
	public void addDirectedEdge(PointNode a, PointNode b) {
		
	}
	
	public void addUndirectedEdge(PointNode a, PointNode b) {
		// if the map doesn't contain point a
		// add it with only b in its adjacency list
		if (!_adjLists.containsKey(a)) {
			_adjLists.put(a, new HashSet<PointNode>(Arrays.asList(b)));
		}
		// if the map contains point a
		// check to see if b is in its adjacency list
		// if not, add b to its adjacency list
		else if (_adjLists.containsKey(a)) {
			if (!_adjLists.get(a).contains(b)) {
				Set<PointNode> aADJ = new HashSet<PointNode>(_adjLists.get(a));
				aADJ.add(b);
				_adjLists.put(a, aADJ);
			}
		}
		// if the map doesn't contain point b
		// add it with only a in its adjacency list
		if (!_adjLists.containsKey(b)) {
			_adjLists.put(b, new HashSet<PointNode>(Arrays.asList(a)));
		}
		// if the map contains point b
		// check to see if a is in its adjacency list
		// if not, add a to its adjacency list
		else if (_adjLists.containsKey(b)) {
			if (!_adjLists.get(b).contains(a)) {
				Set<PointNode> bADJ = new HashSet<PointNode>(_adjLists.get(b));
				bADJ.add(a);
				_adjLists.put(b, bADJ);
			}
		}
	}
	
	// converts the passed-in list to a set and adds it to the map
	// idk what you're supposed to do if the point is already in the map
	public void addAjacencyList(PointNode point, List<PointNode> adjList) {
		Set<PointNode> adjSet = new HashSet<PointNode>();
		adjSet.addAll(adjList);
		_adjLists.put(point, adjSet);
	}
	
	// creates a list
	// adds each segment as the pair of each PointNode and each PointNode in its adjacency list
	// that means it would be a list of double the segments because each segment is repeated forwards and backwards
	// ie has Segment from A to B as both A to B and B to A
	public List<SegmentNode> asSegmentList() {
		List<SegmentNode> segments = new ArrayList<SegmentNode>();
		for (Entry<PointNode, Set<PointNode>> entry : _adjLists.entrySet()) { 
			for (PointNode p : entry.getValue()) {
				segments.add(new SegmentNode(entry.getKey(),p));
			}
		}
		return segments;
	}
	
	public List<SegmentNode> asUniqueSegmentList() {
		return null;
	}
}
