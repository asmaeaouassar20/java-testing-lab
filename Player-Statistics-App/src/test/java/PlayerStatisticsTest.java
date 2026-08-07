import org.algostyle.Player;
import org.algostyle.PlayerStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatisticsTest {
    private Player playerUnderThirty;
    private PlayerStatistics statistics;

    // before EACH test
    // and tests are not run in order
    @BeforeEach
    public void setup(){
        playerUnderThirty = new Player("Asmae",27);
        statistics = new PlayerStatistics(playerUnderThirty,3,3);
    }

    @Test
    public void playerNamesEqual(){
        System.out.println("test 1");
        Player player2 = new Player("Asmae" , 20);
        assertEquals(playerUnderThirty,player2);
    }
    @Test
    public void playerNamesNotEqual(){
        System.out.println("test 2");
        Player player2 = new Player("ali" , 20);
        assertNotEquals(playerUnderThirty,player2);
    }
    @Test
    public void youngerPlayerSame(){
        System.out.println("test 3");
        Player player2 = new Player("Asmae" , 25);
        assertSame( player2, PlayerStatistics.getYoungerPlayer(playerUnderThirty,player2));
    }
    @Test
    public void underThirtyTrue(){
        System.out.println("test 4");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,1,1);
        assertTrue(statistics.underThirty());
    }
    @Test
    public void underThirtyFalse(){
        System.out.println("test 5");
        Player player = new Player("Asmae",33);
        PlayerStatistics statistics = new PlayerStatistics(player,1,1);
        assertFalse(statistics.underThirty());
    }
    @Test
    public void csvReportNull(){
        System.out.println("test 6");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,0,5);
        assertNull(statistics.createCsvRecord());
    }
    @Test
    public void csvReportNotNull(){
        System.out.println("test 7");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,2,5);
        assertNotNull(statistics.createCsvRecord());
    }
    @Test
    public void getCsvStatsRecord(){
        System.out.println("test 8");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,4,8);
        Double[] resultArray = statistics.createCsvRecord();
        Double[] expectedArray = {2d , 0.5};
        assertEquals(2,expectedArray.length);
        assertArrayEquals(expectedArray, resultArray);
    }
}
