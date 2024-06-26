package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class DemoRepeatedTest {
    SimpleMath math;

    @BeforeEach
    void BeforeEachMethod() {
        math = new SimpleMath();
    }

    @RepeatedTest(value = 3, name = "{displayName}. Repetition "
            + "{currentRepetition} of {totalRepetitions}!")
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticExepction(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo) {

        System.out.println("Repetition n: " + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());

        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        // given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessate = "Impossible to divide by zero!";

        // when & then
        ArithmeticException actual = assertThrows(
                ArithmeticException.class, () -> {
                    // when & then
                    math.division(firstNumber, secondNumber);
                }, () -> "Division by zero should trhow an ArithmeticException");

        assertEquals(expectedMessate, actual.getMessage(),
                () -> "Unexpected exception message!");
    }
}