import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        System.out.println("test divide by zero"); // Тест на НАЛИЧИЕ исключения
        //arrange
        int a = 17, b = 0;
        Class<ArithmeticException> expectedType = ArithmeticException.class;

        //act
        Executable executable = () -> sut.divide(a, b);

        //assert
        Assertions.assertThrows(expectedType, executable);
    }

    @Test
    public void testDivideByNonZero() { // Проверка на ОТСУТСТВИЕ исключения
        System.out.println("test divide by non zero");
        //arrange               given
        int a = 17, b = 1345345;

        //act                   when
        Executable executable = () -> sut.divide(a, b);

        //assert                then
        Assertions.assertDoesNotThrow(executable);
    }

    @ParameterizedTest
    @MethodSource("addSource")
    public void testsAddWithParam(int a, int b, int expected) {
        System.out.println("test add with parameters");

        //act
        var result = sut.add(a, b);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> addSource() {
        //arrange
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(10, 20, 30),
                Arguments.of(-50, 20, -30)
        );
    }
}
