import org.algostyle.Player;
import org.algostyle.PlayerStatistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatisticsTest {

    @Test
    public void playerNamesEqual(){
        Player player1 = new Player("Asmae" , 23);
        Player player2 = new Player("Asmae" , 20);
        assertEquals(player1,player2);
    }
    @Test
    public void playerNamesNotEqual(){
        Player player1 = new Player("Asmae" , 23);
        Player player2 = new Player("ali" , 20);
        assertNotEquals(player1,player2);
    }
    @Test
    public void youngerPlayerSame(){
        Player player1 = new Player("Asmae" , 27);
        Player player2 = new Player("Asmae" , 25);
        assertSame( player2, PlayerStatistics.getYoungerPlayer(player1,player2));
    }
    @Test
    public void underThirtyTrue(){
        Player player = new Player("Asmae",23);
        PlayerStatistics statistics = new PlayerStatistics(player,1,1);
        assertTrue(statistics.underThirty());
    }
    @Test
    public void underThirtyFalse(){
        Player player = new Player("Asmae",33);
        PlayerStatistics statistics = new PlayerStatistics(player,1,1);
        assertFalse(statistics.underThirty());
    }
}
