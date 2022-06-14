package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TriangleAreaTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleArea.class);

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        logger.error("ERROR");
        logger.info("INFO");
        logger.trace("TRACE");
        System.out.println("Сбор логов выполнен");
    }


    @Test
    public void checkCorrectTriangleArea() {
        double expected = 6.0;
        double actual = TriangleArea.triangleArea(3, 4, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void checkFalseTriangleArea() {
        double expected = 7.0;
        double actual = TriangleArea.triangleArea(3, 4, 5);
        assertEquals(expected, actual);
    }
}

