import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), "Млекопитающее"},
                {"Травоядное", List.of("Трава", "Различные растения"), "Крокозябра"}
        };
    }

    private String animalKind;
    private List<String> food;
    private String alternativeAnimalKind;

    public LionParamsTest(String animalKind, List<String> food, String alternativeAnimalKind){
        this.animalKind = animalKind;
        this.food = food;
        this.alternativeAnimalKind = alternativeAnimalKind;
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    //Позитивный тест проверки соответствия рациона типу животного

    @Test
    public void lionReturnFoodPositiveTest() throws Exception {
        Lion lion = new Lion(feline);
        Animal animal = new Animal();

        Mockito.when(lion.getFood()).thenReturn(animal.getFood(animalKind));

        List<String> lionExpectedFood = food;
        List<String> lionActualFood = lion.getFood();

        System.out.println("Ожидаемый рацион: " + lionExpectedFood);
        System.out.println(("Актуальный рацион: " + lionActualFood));
        Assert.assertEquals(lionExpectedFood, lionActualFood);
    }


    //Негативный тест проверки соответствия рациона (проверка исключения)

    @Test
    public void lionReturnFoodNegativeTest() throws Exception {
        Lion lion = new Lion(feline);
        Feline feline = new Feline();

        Exception exception = Assert.assertThrows("Проверка исключения", Exception.class, ()-> feline.getFood(alternativeAnimalKind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

}
