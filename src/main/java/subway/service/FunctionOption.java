package subway.service;

public enum FunctionOption {
	SEARCH("1", "경로 조회"),
	QUIT("Q", "종료");

	FunctionOption(String code, String value) {
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
