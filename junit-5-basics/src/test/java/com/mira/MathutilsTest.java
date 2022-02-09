package com.mira;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

class MathutilsTest {

    Mathutils mathutils;

    @BeforeAll
    static void beforeAllInint(){
        System.out.println("This needs to run before all");
    }
    TestInfo testInfo;
    TestReporter testReporter;
    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathutils = new Mathutils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags "+testInfo.getTags());
    }

    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up...");
    }

    @Nested
    class AddTest{
        @DisplayName("Testing add for +ve")
        @Test
        void testAddPositive() {
            assertEquals(2, mathutils.add(1, 1), "The add method should add two number");
        }

        @DisplayName("Testing add for -ve")
        @Test
        void testAddNegative() {
            assertEquals(-2, mathutils.add(-1, -1), "The add method should add two number");
        }

    }

    @Test
    @DisplayName("Testing add method")
    @Tag("Math")
    void testAdd() {
        assertEquals(5, mathutils.add(2, 3), "The add method should add two number");
    }

    @Test
    @DisplayName("Multiply method")
    @Tag("Math")
    void testMultiply(){
        System.out.println("Running " + testInfo.getDisplayName() + " with tags "+testInfo.getTags());

        assertAll(
                () -> assertEquals(4, mathutils.multiply(2,2)),
                () -> assertEquals(6, mathutils.multiply(2,3)),
                () -> assertEquals(0, mathutils.multiply(2,0))
        );
    }

    @Test
    @Tag("Math")
    //@EnabledOnOs(OS.LINUX)
    void testDivide() {
        //boolean isServerup = false;
        //assumeTrue(isServerup);
        assertThrows(ArithmeticException.class, () -> mathutils.divide(1, 0), "Divide by zero should throw");
    }

    @Test
    @Tag("Circle")
    void testCircleRadius() {
        assertEquals(314.1592653589793, mathutils.computeCircleArea(10), "should return circle area");
    }

    @Test
    @DisplayName("TDD method should not run")
    @Disabled
    void testDisabled(){
       fail("This test should be disabled");
    }

}