package proxycglib;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MainCglib {
	
    static class Handler implements MethodInterceptor {
    	private Map<String, Object> cache = new HashMap<>();
        private final ServiceCglibImpl service;
        public Handler(ServiceCglibImpl service) {
            this.service = service;
            Method[] methods = service.getClass().getDeclaredMethods();
    		for(Method m:methods) {
    			if (m.isAnnotationPresent(Cached.class)) {
    			cache.put(m.getName(), null);
    			}
    		}
    		System.out.println(cache);
        }
        
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			if (cache.containsKey(method.getName())) {
	            Object o = cache.get(method.getName());
	            if (o == null) {
	            	System.out.println("New value");
	                String returned = (String) method.invoke(service, args);
	                cache.put(method.getName(), returned);
	                return returned;
	            } else {
	            	System.out.println("From cache");
	                return o;
	            }
	        }
	        return (String) method.invoke(service, args);
		}
    }

	public static void main(String[] args1) {

		ServiceCglibImpl myService = new ServiceCglibImpl();
        MethodInterceptor handler = new Handler(myService);
        ServiceCglibImpl f = (ServiceCglibImpl) Enhancer.create(ServiceCglibImpl.class,handler);
        System.out.println(f.doHardWork1("Hallo"));
		System.out.println(f.doHardWork1("123"));
		System.out.println(f.doHardWork1("123"));
		
	}

}
