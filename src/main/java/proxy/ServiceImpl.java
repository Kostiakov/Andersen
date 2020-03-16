package proxy;

import java.util.Random;

public class ServiceImpl implements Service {

	@Cache
	public double doHardWork(String symbols) {
		Random random = new Random();
        try {
            Thread.sleep(50 + random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Calling service for " + symbols);
        //Call an external service and return result
        return random.nextInt(10);

	}

}
