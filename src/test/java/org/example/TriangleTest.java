package org.example.lesson4;

import lesson4.ThisIsNotTriangleException;
import lesson4.TriangleClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


public class TriangleTest {
    @Test
    void test() throws ThisIsNotTriangleException {
        TriangleClass triangleClass = new TriangleClass();
        Assertions.assertEquals(9, triangleClass.triangleSquare(4, 5, 7));
        Assertions.assertThrows(ThisIsNotTriangleException.class, () -> triangleClass.triangleSquare(-5, 10, 6));
    }

    @ParameterizedTest
    @CsvSource({"2,5,6,4", "10, 7,15,29", "14,13,26,47"})
    void testWithCsvSource(int a, int b, int c, double result) throws ThisIsNotTriangleException {
        TriangleClass triangleClass = new TriangleClass();
        Assertions.assertEquals(result, triangleClass.triangleSquare(a, b, c));

    }

    @ParameterizedTest
    @CsvSource({"-10,20,25", "-1, 2,3", "1,-2,3"})
    void testWithCsvSourceN(int a, int b, int c) throws ThisIsNotTriangleException {
        TriangleClass triangleClass = new TriangleClass();
        Assertions.assertThrows(ThisIsNotTriangleException.class, () -> triangleClass.triangleSquare(a, b, c));
    }
    private static Logger logger= LoggerFactory.getLogger(TriangleTest.class);

}


