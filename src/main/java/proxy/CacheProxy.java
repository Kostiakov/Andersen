package proxy;

public class CacheProxy {
	
	public Service cache(Service service, boolean serialization) {
		return new CachedService(service, serialization);
	}

}
