import org.algostyle.Player;
import org.algostyle.PlayerStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(player2).isEqualTo(playerUnderThirty);
    }
    @Test
    public void playerNamesNotEqual(){
        System.out.println("test 2");
        Player player2 = new Player("ali" , 20);
        assertThat(player2).isNotEqualTo(playerUnderThirty);
    }
    @Test
    public void youngerPlayerSame(){
        System.out.println("test 3");
        Player player2 = new Player("Asmae" , 25);
        assertThat(PlayerStatistics.getYoungerPlayer(playerUnderThirty,player2)).isSameAs(player2);
    }
    @Test
    public void underThirtyTrue(){
        System.out.println("test 4");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,1,1);
        assertThat(statistics.underThirty()).isTrue();
    }
    @Test
    public void underThirtyFalse(){
        System.out.println("test 5");
        Player player = new Player("Asmae",33);
        PlayerStatistics statistics = new PlayerStatistics(player,1,1);
        assertThat(statistics.underThirty()).isFalse();
    }
    @Test
    public void csvReportNull(){
        System.out.println("test 6");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,0,5);
        assertThat(statistics.createCsvRecord()).isNull();
    }
    @Test
    public void csvReportNotNull(){
        System.out.println("test 7");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,2,5);
        assertThat(statistics.createCsvRecord()).isNotNull();
    }
    @Test
    public void getCsvStatsRecord(){
        System.out.println("test 8");
        PlayerStatistics statistics = new PlayerStatistics(playerUnderThirty,4,8);
        Double[] resultArray = statistics.createCsvRecord();
        Double[] expectedArray = {2d , 0.5};
        assertEquals(2,expectedArray.length);
        assertThat(resultArray).isEqualTo(expectedArray);
    }
}
