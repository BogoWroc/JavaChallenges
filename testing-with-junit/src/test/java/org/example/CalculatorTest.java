package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Verify the calculator logic")
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3",
            "5, 5, 10"
    })
    @DisplayName("should returns the result of add operation")
    public void shouldAddTwoNumbers(int a, int b, int result) {
        assertThat(calculator.add(a, b)).isEqualTo(result);
    }

    @Nested
    @DisplayName("simulate group of nested tests")
    public class NestedTests {

        @Test
        @DisplayName("some nested test")
        public void nestedTest() {

        }

        @Test
        @DisplayName("some disabled nested test")
        @Disabled
        public void nestedDisabledTest() {

        }

        @Test
        @DisplayName("some tagged nested test")
        @Tag("slow")
        public void nestedTaggedTest() {

        }
    }
}
