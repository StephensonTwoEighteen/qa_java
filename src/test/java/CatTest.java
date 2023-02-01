import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {


    @Mock
    Feline feline;

    @Test
    public void getSoundTest(){
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        System.out.println("Ожидаемый звук: " + expected);
        System.out.println("Настоящий звук: " + actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() {
        Feline feline = new Feline();

        Exception exception = Assert.assertThrows("Проверка исключения", Exception.class, ()-> feline.getFood("Млекопитающее"));
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
