package org.softwaretechnologies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTaskTest {
    static PrintStream originalOut = System.out;
    static ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        outContent.reset();
        System.setOut(originalOut);
    }

    @Test
    void printMessage() {
        assertThrows(RuntimeException.class, ExceptionTask::printMessage);
        String s = outContent.toString();
        assertEquals("Вызвана функция printMessage" + System.lineSeparator(), s);
    }

    @Test
    void printMessage2() {
        assertThrows(Exception.class, ExceptionTask::printMessage2);
        String s = outContent.toString();
        assertEquals("Вызвана функция printMessage2" + System.lineSeparator(), s);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void divide() throws DivideOnNullException {
        assertThrowsExactly(DivideOnNullException.class, () -> ExceptionTask.divide(45, 0));
        int divide = ExceptionTask.divide(45, 5);
        assertEquals(9,divide);
        divide = ExceptionTask.divide(0, 5);
        assertEquals(0,divide);
    }

    @Test
    void mergeStrings() {
        Optional<String> empty = ExceptionTask.mergeStrings(null, null);
        assertTrue(empty.isEmpty());
        Optional<String> firstNull = ExceptionTask.mergeStrings(null, "second");
        assertFalse(firstNull.isEmpty());
        assertEquals("second", firstNull.get());

        Optional<String> secondNull = ExceptionTask.mergeStrings("first", null);
        assertFalse(secondNull.isEmpty());
        assertEquals("first", secondNull.get());

        Optional<String> firstIsBigger = ExceptionTask.mergeStrings("aaaaaaaaa", "bbb");
        assertFalse(firstIsBigger.isEmpty());
        assertEquals("aaaaaaaaabbb", firstIsBigger.get());

        Optional<String> secondIsBigger = ExceptionTask.mergeStrings("bbb", "aaaaaaaaa");
        assertFalse(secondIsBigger.isEmpty());
        assertEquals("aaaaaaaaabbb", secondIsBigger.get());

    }
}