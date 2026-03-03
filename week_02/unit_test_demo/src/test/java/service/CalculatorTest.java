package service;

import org.example.service.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp () {
        // inject service
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown () {
        calculator = null;
    }

    @Test
    void givenTwoInts_whenAdd_thenReturnSum() {
        assertEquals(5, calculator.add(2,3));
    }

    @Test
    void givenTwoLongs_whenMultiply_thenReturnResult () {
        assertEquals(12, calculator.multiply(3,4));
    }

    @Test
    void givenZero_whenMultiply_thenReturnZero () {
        assertEquals(0, calculator.multiply(0,4));
    }

    @Test
    void givenTwoLongs_whenSubstract_thenReturnDifference() {
        assertEquals(-12, calculator.subtract(3, 15));
    }

    @Test
    void givenTwoDouble_whenDivide_thenReturnResult () {
        assertEquals(3.0, calculator.divide(45.0, 15.0));
    }
    @Test
    void givenDividerZero_whenDivide_thenThrowArithmeticException() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculator.divide(10.0, 0.0));
        assertEquals("Divide by zero", ex.getMessage());
    }
}
