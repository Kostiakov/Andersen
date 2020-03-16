package proxy;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedService implements Service, Serializable {
	
	private boolean serialization;
	private Service service;
	private Map<String, Double> cache = new ConcurrentHashMap<>();
	
	public CachedService(Service service, boolean serialization) {
		this.service=service;
		this.serialization=serialization;
	}

	public double doHardWork(String symbols) {
		
		//при сериализации в файл на диске
		if(serialization) {
		
		ObjectInputStream objectInputStream;
		
		try {
			objectInputStream = new ObjectInputStream(
			        new FileInputStream("src/main/java/proxy/test.out"));
			cache = (ConcurrentHashMap<String, Double>) objectInputStream.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(cache);
		System.out.println(cache.get(symbols));
		
		//если нет ключа в map, то считаем значение для ключа
		
		double d = cache.computeIfAbsent(symbols, 
	            stockSymbol -> service.doHardWork(stockSymbol));
		
		try {
			FileOutputStream fileOutputStream =
	                new FileOutputStream("src/main/java/proxy/test.out");
	        ObjectOutputStream objectOutputStream =
	                new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(cache);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return d;
		}
		
		//при сериализации в памяти
		else {
			double d = cache.computeIfAbsent(symbols, 
		            stockSymbol -> service.doHardWork(stockSymbol));
			return d;
		}

	}

}
