import org.algostyle.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    Player player=new Player("Asmae",23);

    @Before
    public void setup(){
        System.out.println("setup");
    }

    @Test
    public void testIsMajor(){
        boolean isMajor = player.isMajor();
        assertTrue(isMajor);
    }

    @After
    public void tearDown(){
        System.out.println("teardown");
    }
}
