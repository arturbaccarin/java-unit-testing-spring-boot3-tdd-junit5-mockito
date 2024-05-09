package br.com.erudio.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test Math Operations in SimpleMath Class")
public class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void BeforeEachMethod() {
        math = new SimpleMath();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Pelé", "Senna", "Santos" })
    void testValueSource(String firstName) {
        System.out.println(firstName);
        Assertions.assertNotNull(firstName);
    }

    @DisplayName("Test Division [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    // @MethodSource("testDivisionInputParameters")
    // @CsvSource({
    // "6.2, 2, 3.1",
    // "71, 14, 5.07"
    // })
    @CsvFileSource(resources = "/testDivision.csv")
    void TestDivision(double firstNumber, double secondNumber, double expected) {
        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                        "did not produce " + expected + "!");
    }

    // public static Stream<Arguments> testDivisionInputParameters() {
    // return Stream.of(
    // Arguments.of(6.2D, 2D, 3.1D),
    // Arguments.of(15D, 5D, 3D));
    // }
}
