package proxymethods;

public class ServiceImpl implements Service {

	
	@Override
	@Caching
	public String doHardWork1(String params) {
		System.out.println("Impl doHardWork1");
		return params;
	}

	@Override
	public String doHardWork2(String params) {
		System.out.println("Impl doHardWork2");
		return params;
	}

	@Override
	public String doHardWork3(String params) {
		System.out.println("Impl doHardWork3");
		return params;
	}

}
