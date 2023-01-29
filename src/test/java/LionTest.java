import com.example.Animal;
import com.example.Feline;
import com.example.Kittens;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец");

        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        try {
            lion.doesHaveMane();
        } catch (Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
        assertEquals(expectedHasMane, actualHasMane);
        System.out.println(lion.doesHaveMane());
    }


    @Mock
    Kittens kittens;

    @Test
    public void getKittensTest() {

        Lion lion = new Lion(kittens);

        Mockito.when(kittens.getKittens()).thenReturn(0);
        int expectedCount = 0;
        int actualCount = lion.getKittens();
        assertEquals(expectedCount, actualCount);
        System.out.println(lion.getKittens());
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);

        List<String> lionExpectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> lionActualFood = lion.getFood("Хищник");
        try {
            lion.getFood("Хищник");
        } catch (Exception exception) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }

        assertEquals(lionExpectedFood, lionActualFood);

    }
}