package subway;

import java.util.Arrays;
import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitializer {
	private static final List<String> stationNames = Arrays.asList(
		"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
	);

	public static void init() {
		initStation();
	}

	private static void initStation() {
		for (String stationName : stationNames) {
			StationRepository.addStation(new Station(stationName));
		}
	}
}