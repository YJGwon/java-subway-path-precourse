package subway;

import java.util.Arrays;
import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitializer {
	private static final String STATION_GYODAE = "교대역";
	private static final String STATION_GANGNAM = "강남역";
	private static final String STATION_YUKSAM = "역삼역";
	private static final String STATION_NAMBOO = "남부터미널역";
	private static final String STATION_YANGJAE = "양재역";
	private static final String STATION_YANGJAESOOP = "양재시민의숲역";
	private static final String STATION_MAEBONG = "매봉역";

	private static final String LINE_TWO = "2호선";
	private static final String LINE_THREE = "3호선";
	private static final String LINE_SINBOONDANG = "신분당선";

	private static final int KM_ONE = 1;
	private static final int KM_TWO = 2;
	private static final int KM_THREE = 3;
	private static final int KM_SIX = 6;
	private static final int KM_TEN = 10;

	private static final List<String> stationNames = Arrays.asList(
		STATION_GYODAE, STATION_GANGNAM, STATION_YUKSAM,
		STATION_NAMBOO, STATION_YANGJAE, STATION_YANGJAESOOP, STATION_MAEBONG
	);
	private static final List<String> lineNames = Arrays.asList(
		LINE_TWO, LINE_THREE, LINE_SINBOONDANG
	);

	public static void init() {
		initStations();
		initLines();
		initStationsInLines();
		initDistanceGraph();
	}

	private static void initStations() {
		for (String stationName : stationNames) {
			StationRepository.addStation(new Station(stationName));
		}
	}

	private static void initLines() {
		for (String lineName : lineNames) {
			LineRepository.addLine(new Line(lineName));
		}
	}

	private static void initStationsInLines() {
		initStationsInLine2();
		initStationsInLine3();
		initStationInLineSinBoonDang();
	}

	private static void initDistanceGraph() {
		WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = makeDefaultGraph();
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GYODAE, STATION_GANGNAM), KM_TWO);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GANGNAM, STATION_YUKSAM), KM_TWO);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GYODAE, STATION_NAMBOO), KM_THREE);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_NAMBOO, STATION_YANGJAE), KM_SIX);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_YANGJAE, STATION_MAEBONG), KM_ONE);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_GANGNAM, STATION_YANGJAE), KM_TWO);
		distanceGraph.setEdgeWeight(distanceGraph.addEdge(STATION_YANGJAE, STATION_YANGJAESOOP), KM_TEN);
	}

	private static WeightedMultigraph<String, DefaultWeightedEdge> makeDefaultGraph() {
		WeightedMultigraph<String, DefaultWeightedEdge> defaltGraph = new WeightedMultigraph(
			DefaultWeightedEdge.class);
		for (String stationName : stationNames) {
			defaltGraph.addVertex(stationName);
		}
		return defaltGraph;
	}

	private static void initStationsInLine2() {
		Line lineTwo = LineRepository.get(LINE_TWO);
		lineTwo.addStation(StationRepository.get(STATION_GYODAE));
		lineTwo.addStation(StationRepository.get(STATION_GANGNAM));
		lineTwo.addStation(StationRepository.get(STATION_YUKSAM));
	}

	private static void initStationsInLine3() {
		Line lineThree = LineRepository.get(LINE_THREE);
		lineThree.addStation(StationRepository.get(STATION_GYODAE));
		lineThree.addStation(StationRepository.get(STATION_NAMBOO));
		lineThree.addStation(StationRepository.get(STATION_YANGJAE));
		lineThree.addStation(StationRepository.get(STATION_MAEBONG));
	}

	private static void initStationInLineSinBoonDang() {
		Line lineSinBoonDang = LineRepository.get(LINE_SINBOONDANG);
		lineSinBoonDang.addStation(StationRepository.get(STATION_GANGNAM));
		lineSinBoonDang.addStation(StationRepository.get(STATION_YANGJAE));
		lineSinBoonDang.addStation(StationRepository.get(STATION_YANGJAESOOP));
	}
}
