package proxymethods;

public interface Service {
	@Caching
	public String doHardWork1(String params);
	public String doHardWork2(String params);
	public String doHardWork3(String params);

}
