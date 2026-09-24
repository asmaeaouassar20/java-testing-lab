package custommatcher;

import org.algostyle.Player;
import org.assertj.core.api.AbstractAssert;

public class PlayerAssert extends AbstractAssert<PlayerAssert, Player> {
    public static PlayerAssert assertThat(Player player){
        return new PlayerAssert(player);
    }
    public PlayerAssert(Player player) {
        super(player, PlayerAssert.class);
    }

    public void hasName(String expectedName){
        isNotNull();
        if(!actual.getName().equals(expectedName)){
            failWithMessage("Expected: "+expectedName+" , but was: "+actual.getName());
        }
    }
}
