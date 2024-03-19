package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTests {
    private Animal animal;

    @Before
    public void setUp() throws Exception {
        animal = new Animal();
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        List<String> food = animal.getFood("Травоядное");
        assertTrue(food.containsAll(List.of("Трава", "Различные растения")));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        List<String> food = animal.getFood("Хищник");
        assertTrue(food.containsAll(List.of("Животные", "Птицы", "Рыба")));
    }



        @Test
        public void testGetFamily() {
            String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
            String actual = animal.getFamily();
            assertEquals(expected, actual);
        }
    }


