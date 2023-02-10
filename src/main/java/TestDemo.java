import java.util.Random;

public class TestDemo {
	
	private Random random = new Random();
	private static final int MAX_RANDOM = 10;
	
	//generates random in and returns that number squared
	public int randomNumberSquared () {
		int a = generateRandomInteger();
			 
		return a*a;
		
	}
	//generates a random int up to 10
	int generateRandomInteger() {
		return random.nextInt(MAX_RANDOM) + 1;
	}

	//if both parameters are positive, add them together. If one or both are not positive, throw an exception
	public int addPositive(int a, int b) {
		if (a % 2 == 0 && b % 2 == 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
	}
	


	
}
