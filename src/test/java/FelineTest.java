import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

        System.out.println(expectedFamily);
        System.out.println("Относится к семейству: " + actualFamily);
        Assert.assertTrue(expectedFamily.contains(actualFamily.toLowerCase()));
    }



    @Test
    public void getKittensTest(){
        Feline feline = new Feline();

        int expectedkittensCount = 1;
        int actualKittensCount = feline.getKittens(1);

        assertEquals(expectedkittensCount, actualKittensCount);
    }


    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();

        List <String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);

    }


    @Test
    public void eatMeatExceptionTest() {
        Feline feline = new Feline();

        Exception exception = Assert.assertThrows("Проверка исключения", Exception.class, ()-> feline.getFood("Млекопитающее"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
