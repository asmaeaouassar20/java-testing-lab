import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.algostyle.PlayerScoreCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class) // indique à JUnit d’utiliser le moteur JUnitParams pour exécuter le test afin de permettre l’utilisation de tests paramétrés avec plusieurs jeux de données.
public class PlayerScoreCalculatorTestParams {
    private static Object[] testValues(){
        return new Object[]{
                new Object[]{50, 50, 2500},
                new Object[]{-10 , 50, -1},
                new Object[]{50, -10, -1},
                new Object[]{0, 0, 0}
        };
    }
    @Test
    @Parameters(method = "testValues")
    public void playerScoreCalculator(int score1, int score2, int expectedResScore){
        PlayerScoreCalculator sc = new PlayerScoreCalculator();
        sc.calculateResScore(score1,score2);
        assertEquals(expectedResScore,sc.getResScore());
    }
}
