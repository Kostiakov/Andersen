package proxymethods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements InvocationHandler {
	private Map<String, String> cache = new HashMap<>();
	private Object obj;
	
	public CacheProxy(Object obj) {
		this.obj=obj;
		Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method m:methods) {
			cache.put(m.getName(), null);
		}
		System.out.println(cache);
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if (cache.containsKey(method.getName())) {
            String o = cache.get(method.getName());
            if (o == null) {
            	System.out.println("New value");
                String returned = (String) method.invoke(obj, args);
                cache.put(method.getName(), returned);
                return returned;
            } else {
            	System.out.println("From cache");
                return o;
            }
        }
        return method.invoke(args);
	}

}
