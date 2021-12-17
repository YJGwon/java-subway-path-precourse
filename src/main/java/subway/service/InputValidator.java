package subway.service;

import java.util.Arrays;

import subway.domain.StationRepository;

public class InputValidator {
	private static final String ERROR_MESSAGE_NO_SUCH_FUNCTION = "주어진 기능 내에서 선택해주세요(기호로 선택).";
	private static final String ERROR_MESSAGE_SAME_STATION = "출발역과 도착역이 동일합니다.";
	private static final String ERROR_MESSAGE_NO_SUCH_STATION = "존재하지 않는 역입니다.";

	public void validateFunction(String input) {
		if (Arrays.stream(FunctionOption.values())
			.noneMatch(option -> input.equals(option.getCode()))) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_FUNCTION);
		}
	}

	public void validateSearchOption(String input) {
		if (Arrays.stream(SearchOption.values())
			.noneMatch(option -> input.equals(option.getCode()))) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_FUNCTION);
		}
	}

	public void validateStationInput(String stationName) {
		if (!StationRepository.hasStation(stationName)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NO_SUCH_STATION);
		}
	}

	public void validateTwoStation(String departure, String destination) {
		if (departure.equals(destination)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_SAME_STATION);
		}
	}
}
