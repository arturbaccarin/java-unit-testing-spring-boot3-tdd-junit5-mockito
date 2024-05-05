package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void BeforeEachMethod() {
        System.out.println("Running @BeforeEach method!");
        math = new SimpleMath();
    }

    @AfterEach
    void AfterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @Test
    @DisplayName("Test 6.2D + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        // BDD

        // Triple A (AAA) -> Arrange, Act, Assert

        // Given
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

    @Disabled("TODO: we need work on it!")
    @Test
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        fail();
    }
}
