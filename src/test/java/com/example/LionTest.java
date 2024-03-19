package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;


@RunWith(MockitoJUnitRunner.class)

    public class LionTest extends TestCase {
        private static final String MALE = "Самец";

        private static final String FEMALE = "Самка";
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
            lion = new Lion(MALE, feline);

            lion.getFood();
            Mockito.verify(feline).getFood(Mockito.anyString());
        }


        @Test public void testGetFoodFemale() throws Exception {
        lion = new Lion(FEMALE, feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
        }
}




