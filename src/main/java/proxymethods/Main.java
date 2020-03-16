package proxymethods;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		ServiceImpl service = new ServiceImpl();
		/*Service proxyService = (Service)Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),
				ServiceImpl.class.getInterfaces(), new CacheProxy(service));
		proxyService.doHardWork1("123");
		proxyService.doHardWork1("123");*/
		Service proxyService=CacheProxy.cache(service, Service.class);
		proxyService.doHardWork1("123");
		proxyService.doHardWork1("123");
		
	}

}
