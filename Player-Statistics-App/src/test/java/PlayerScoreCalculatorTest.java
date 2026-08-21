import org.algostyle.PlayerScoreCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
