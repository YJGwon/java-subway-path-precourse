package subway;

import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitializer {
	private static final List<String> stationNames = Arrays.asList(
		"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
	);
	private static final List<String> lineNames = Arrays.asList(
		"2호선", "3호선", "신분당선"
	);

	public static void init() {
		initStations();
		initLines();
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
}