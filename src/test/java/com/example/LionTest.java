package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)

    public class LionTest {
    private static final String MALE = "Самец";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";
    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion(UNSUPPORTED_SEX, feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }


    @Test
    public void testGetFoodMale() throws Exception {
        Lion lion = new Lion(MALE, feline);

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}

