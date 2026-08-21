import org.algostyle.PlayerScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerScoreCalculatorTest {

    PlayerScoreCalculator sc;

    @BeforeEach
    public void setup(){
        sc=new PlayerScoreCalculator();
    }

    @Test
    public void playerScoreCalculatorRegular(){
        sc.calculateResScore(50,50);
        assertEquals(2500 , sc.getResScore());
    }
    @Test
    public void playerScoreCalculatorScore1Negative(){
        sc.calculateResScore(-10,50);
        assertEquals(-1 , sc.getResScore());
    }
    @Test
    public void playerScoreCalculatorScore2Negative(){
        sc.calculateResScore(50,-10);
        assertEquals(-1 , sc.getResScore());
    }
    @Test
    void getSpecificScoreHappyPath(){
        assertEquals(3.45F, sc.getSpecificScore(5));
    }
    @Test
    void getSpecificScoreThrowsException(){
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> sc.getSpecificScore(-5),
                "la méthode getSpecificScore lance une exception lorsque le scrore est hors l'interval demandé"
        );
        assertEquals("Calculator cannot accept score value : -5", exception.getMessage());
    }
    @Test
    void getSpecificScoreNullIntegerArgument(){
        Float result = sc.getSpecificScore(null);
        assertEquals(0F, result);
    }
    @Test
    void getSpecificScoreNaNArgument(){
        Integer NaNNumber = (int) Math.sqrt(-5d);
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                ()->sc.getSpecificScore(NaNNumber),
                "La méthode getSpecificScore lance une exception lorsque NaN est passée en param"
        );
        assertEquals("Calculator cannot accept score value : "+NaNNumber,exception.getMessage());
    }

}
