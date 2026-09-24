import custommatcher.PlayerAssert;
import org.algostyle.Player;
import org.junit.jupiter.api.Test;

import static custommatcher.PlayerAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class PlayerStatisticsTestCustomMatcher {
    @Test
    public void playerConstructorAssignsNameSuccess(){
        Player player=new Player("Asmae",23);
        assertThat(player).hasName("Asmae");
    }

    @Test
    public void playerConstructorAssignsNameFail(){
        Player player=new Player("Asmae",23);
        AssertionError exception = assertThrows(
                AssertionError.class,
                () -> PlayerAssert.assertThat(player).hasName("Asma")
        );
        org.assertj.core.api.Assertions.assertThat(exception).hasMessage("Expected: Asma , but was: Asmae");
    }
}
