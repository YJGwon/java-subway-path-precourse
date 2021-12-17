package subway.service;

public enum SearchOption {
	DISTANCE("1", "최단 거리"),
	TIME("2", "최소 시간"),
	GO_BACK("B", "돌아가기");

	SearchOption(String code, String value) {
		this.code = code;
		this.value = value;
	}

	private final String code;
	private final String value;

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}
}
