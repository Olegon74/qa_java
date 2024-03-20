package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTest {

    @Test
    public void getFamilyIsCorrect() {
        String expected = "Кошачьи";
        MatcherAssert.assertThat("Некорректное название семейства кошачьих", new Feline().getFamily(), equalTo(expected));
    }

    @Test
    public void getKittensInputCountIsCorrect() {
        int expected = 5;
        MatcherAssert.assertThat("Некорректное количество котят", new Feline().getKittens(expected), equalTo(expected));
    }

    @Test
    public void getKittensDefaultIsCorrect() {
        int expected = 1;
        MatcherAssert.assertThat("Некорректное количество котят", new Feline().getKittens(), equalTo(expected));
    }

    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline();

        MatcherAssert.assertThat("Неправильный список еды", feline.eatMeat(), equalTo(feline.getFood("Хищник")));
    }
}
