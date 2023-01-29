import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), "Млекопитающее", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения"), "Крокозябра", List.of("Трава", "Различные растения")}
        };
    }

    private String animalKind;
    private List<String> food;
    private String alternativeAnimalKind;
    private List<String> alternativeFood;

    public LionParamsTest(String animalKind, List<String> food, String alternativeAnimalKind, List<String> alternativeFood){
        this.animalKind = animalKind;
        this.food = food;
        this.alternativeAnimalKind = alternativeAnimalKind;
        this.alternativeFood = alternativeFood;
    }

    @Mock
    Feline feline;

    //Позитивный тест проверки соответствия рациона типу животного

    @Test
    public void lionReturnFoodPositiveTest() throws Exception {
        Lion lion = new Lion(feline);

        List<String> lionExpectedFood = food;
        List<String> lionActualFood = lion.getFood(animalKind);
        try {
            Assert.assertEquals(lionExpectedFood, lionActualFood);
        } catch (Exception exception) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }


    //Негативный тест проверки соответствия рациона (проверка исключения)

    @Test
    public void lionReturnFoodNegativeTest() throws Exception {
        Lion lion = new Lion(feline);

        Exception exception = Assert.assertThrows("Проверка исключения", Exception.class, ()-> lion.getFood(alternativeAnimalKind));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

}
