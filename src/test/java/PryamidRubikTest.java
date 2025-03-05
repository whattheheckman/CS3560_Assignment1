import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PryamidRubikTest {
    @Test
    public void testIsValid() {
       PryamidRubik test_cube = new PryamidRubik();
       assertTrue(test_cube.validateCube());
    }
}
