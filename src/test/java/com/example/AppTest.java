package com.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void getGreetingReturnsHello() {
        assertEquals("Hello", App.getGreeting());
    }

    @Test
    void mainPrintsHello() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream capturedOut = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(capturedOut));
            App.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("Hello" + System.lineSeparator(), capturedOut.toString());
    }
}
