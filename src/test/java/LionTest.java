import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
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

        assertEquals(expectedHasMane, actualHasMane);
        System.out.println(lion.doesHaveMane());
    }


    @Mock
    Feline feline;

    @Test
    public void getKittensTest() {

        Lion lion = new Lion(feline);

        Mockito.when(feline.getKittens()).thenReturn(0);
        int expectedCount = 0;
        int actualCount = lion.getKittens();
        assertEquals(expectedCount, actualCount);
        System.out.println("Количество котят: " + lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        Animal animal = new Animal();

        Mockito.when(feline.getFood("Хищник")).thenReturn(animal.getFood("Хищник"));
        List<String> lionExpectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> lionActualFood = lion.getFood();
        System.out.println("Ожидаемый рацион: " + lionExpectedFood);
        System.out.println(("Актуальный рацион: " + lionActualFood));

        assertEquals(lionExpectedFood, lionActualFood);
    }
}









