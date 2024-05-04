package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2D + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        // BDD

        // Triple A (AAA) -> Arrange, Act, Assert

        // Given
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expected = 8.2D;

        // When
        Double actual = math.sum(firstNumber, secondNumber);

        // Then
        Assertions.assertEquals(expected, actual,
                () -> firstNumber + "+" + secondNumber + " did not produce " + expected + "!");
        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(9.2, actual);
    }

    @Test
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        fail();
    }
}
