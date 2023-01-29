import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Kittens;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    Animal animal;

    @Test
    public void getFamilyTest(){
        Feline feline = new Feline();

        Mockito.when(animal.getFamily()).thenReturn("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        String expectedFamily = animal.getFamily();
        String actualFamily = feline.getFamily();
        expectedFamily.contains(actualFamily);

        System.out.println(expectedFamily);
        System.out.println(actualFamily);
    }

    @Test
    public void getKittensTest(){
        Feline feline = new Feline();

        int expectedkittensCount = 1;
        int actualKittensCount = feline.getKittens(1);

        Assert.assertEquals(expectedkittensCount, actualKittensCount);
    }


    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();

        List <String> expected = List.of("Животные", "Птицы", "Рыба");
        try {
            feline.eatMeat();
        } catch (Exception exception) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);

    }
}
