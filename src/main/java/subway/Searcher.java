package subway;

import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Searcher {
	private static final String ERROR_MESSAGE_NO_PATH = "경로가 존재하지 않습니다.";

	private final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
	private final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;

	public Searcher(
		WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph,
		WeightedMultigraph<String, DefaultWeightedEdge> timeGraph) {
		this.distanceGraph = distanceGraph;
		this.timeGraph = timeGraph;
	}

	public List<String> searchPath(String departure, String destination, SearchOption option) {
		if (option == SearchOption.DISTANCE) {
			return getShortestPath(departure, destination, new DijkstraShortestPath(distanceGraph));
		}
		return getShortestPath(departure, destination, new DijkstraShortestPath(timeGraph));
	}

	private List<String> getShortestPath(
		String departure, String destination, DijkstraShortestPath dijkstraShortestPath) {
		try {
			return dijkstraShortestPath.getPath(departure, destination).getVertexList();
		} catch (NullPointerException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_PATH);
		}
	}
}
