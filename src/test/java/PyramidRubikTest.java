import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PyramidRubikTest {
    @Test
    public void testIsValid() {
       PyramidRubik test_cube = new PyramidRubik();
       assertTrue(test_cube.validateCube());
    }
}
