import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;


import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}

	//
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
	//Given: two numbers (a and b), do we get the expected output? If not, throw an illegal exception	
		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
			}
		else {
		assertThatThrownBy(() -> 
	    testDemo.addPositive(a, b))
	        .isInstanceOf(IllegalArgumentException.class);
		}
	}
	//heres the source method with the arguments to test as many times as necessary
	static Stream<Arguments> argumentsForAddPositive () {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 4, 4, false),
				arguments(3, 4, 7, true)
				);
	}
	
	//created a mock since we don't know what random number we will get. used Spy to create a spy on the specific method I want to mock, used 5 squared which equals 25
	@Test
	void assertThatNumberSquaredIsCorrect () {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).generateRandomInteger();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	

	}
	

}
