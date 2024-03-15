package commonUtils;

import java.util.Random;

public class JavaUtil {
	public int getRandomNumber() {
		//Call random method
		Random r = new Random();
		int ran=r.nextInt(1000);
		return ran;
	}
}
