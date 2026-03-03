package service;

import org.example.service.Factorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    void givenN_whenFactorial_thenReturnResult () {
        assertEquals(1, factorial.factorialCount(0));
        assertEquals(1, factorial.factorialCount(1));
        assertEquals(120, factorial.factorialCount(5));
    }
}
