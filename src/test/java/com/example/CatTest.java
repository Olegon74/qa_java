package com.example;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundIsCorrect() {
        String expected = "Мяу";
        MatcherAssert.assertThat(new Cat(feline).getSound(), equalTo(expected));
    }


    @Test
    public void getFoodSuitable() throws Exception {
    Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Вернулся некорректный список еды", cat.getFood(), equalTo(expectedListOfFood));
    }

}




