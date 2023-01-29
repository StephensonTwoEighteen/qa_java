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
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }

}
