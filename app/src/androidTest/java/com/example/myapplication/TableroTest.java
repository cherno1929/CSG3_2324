package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableroTest {

    private Tablero tablero;

    @Before
    public void setUp() {
        tablero = new Tablero();
    }

    @Test
    public void testGetElements() {
        Character[][] elements = tablero.getElements();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(Character.valueOf('-'), elements[i][j]);
            }
        }
    }

    @Test
    public void testMarkCircle() {
        tablero.markCircle(1, 1);
        assertEquals('o', tablero.getPos(1, 1));
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero.markCircle(i, j);
            }
        }
        assertTrue(tablero.isFull());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tablero.isEmpty(1, 1));
        tablero.markCircle(1, 1);
        assertFalse(tablero.isEmpty(1, 1));
    }
}