package proxy;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Service service = new ServiceImpl();
		boolean serialization = false;
		
        List<String> symbols = Arrays.asList(
                "GOOGL", "AMZ", "FB", "MSFT",
                "GOOGL", "DBZR", "FB", "MSFT",
                "GOOGL", "AMZ", "FB", "MSFT");
        //symbols.forEach(service::doHardWork);
        //service = new CachedService(service);
        service = new CacheProxy().cache(service, serialization);
        System.out.println("Using a proxy");
        symbols.forEach(service::doHardWork);

	}

}
