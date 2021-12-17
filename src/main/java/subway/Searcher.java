package subway;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Searcher {
	private WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
	private WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

	public Searcher(
		WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph,
		WeightedMultigraph<String, DefaultWeightedEdge> timeGraph) {
		this.distanceGraph = distanceGraph;
		this.timeGraph = timeGraph;
	}
}
