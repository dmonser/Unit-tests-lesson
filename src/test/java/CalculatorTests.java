import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTests {
    Calculator sut;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all test");
//        sut = new Calculator();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all test");
//        sut = null;
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each test");
        sut = new Calculator();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each test");
        sut = new Calculator();
    }
    @Test
    public void testsAdd() {
        System.out.println("test add");
        //arrange
        int a = 1, b = 2, expected = 3;

        //act
        var result = sut.add(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSubtraction() {
        System.out.println("test subtraction");
        //arrange
        int a = 3, b = 2, expected = 1;

        //act
        var result = sut.subtraction(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
        System.out.println("test multiply");
        //arrange
        int a = 3, b = 2, expected = 6;

        //act
        var result = sut.multiply(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDivide() {
        System.out.println("test divide");
        //arrange
        int a = 17, b = 2, expected = 8;

        //act
        var result = sut.divide(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDivideByZero() {
        System.out.println("test divide by zero");
        //arrange
        int a = 17, b = 0;
        Class<ArithmeticException> expectedType = ArithmeticException.class;

        //act
        Executable executable = () -> sut.divide(a, b);

        //assert
        Assertions.assertThrows(expectedType, executable);
    }
}
