package proxymethods;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


public class CacheProxy<T> implements InvocationHandler {
	private Map<String, String> cache = new HashMap<>();
	private Object obj;
	
	public CacheProxy(T obj) {
		this.obj=obj;
		Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method m:methods) {
			cache.put(m.getName(), null);
		}
		System.out.println(cache);
		
	}
	
	
    public static <I, T extends I> I cache (T t, Class<I> interfaceClass) {
        CacheProxy cacheableDecorator = new CacheProxy(t);
        return (I) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                                          new Class[]{interfaceClass}, cacheableDecorator);

    }
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Annotation[] anno = method.getAnnotations();
		System.out.println(anno.length);
		if(method.isAnnotationPresent(Caching.class)) {
		
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
		
		else {
			System.out.println("no cashing");
			return method.invoke(obj, args);
			
		}
        
	}

}
