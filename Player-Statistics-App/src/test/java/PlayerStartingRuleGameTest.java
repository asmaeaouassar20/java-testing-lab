import org.algostyle.InvalidCardNumber;
import org.algostyle.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerStartingRuleGameTest {
    @Test
    public void testValidateStartingRuleGameThrowsIllegalArgumentException(){
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{
            Player.validateStartingRuleGame("PINK",5);
        });
        assertEquals("Color PINK not within accepted colors" , exception.getMessage());
    }

    // OR id you are using Junit 4
   /* @Test(expected = IllegalArgumentException.class) // pk mon ide ne connait pas "expected"
    public void testvVlidateStartingRuleGameThrowsIllegalArgumentException2(){
        Player.validateStartingRuleGame("PINK",5);
    }*/

    @Test
    public void testValidateStartingRuleGameThrowsInvalidCardNumber(){
        Throwable exception = assertThrows(InvalidCardNumber.class, ()->{
            Player.validateStartingRuleGame("RED",-15);
        });
        assertEquals("cardNumber must be greater than 0" , exception.getMessage());
    }


    // expected exceptions cn be encapsulated by parents class, SO
    @Test
    public void testValidateStartingRuleGameThrowsRuntimeException1(){
        Throwable exception = assertThrows(RuntimeException.class, ()->{
            Player.validateStartingRuleGame("blue", 10);
        } );
        assertEquals("Color blue not within accepted colors", exception.getMessage());
    }

    @Test
    public void testValidateStartingRuleGameThrowsRuntimeException2(){
        Throwable exception = assertThrows(RuntimeException.class, ()->{
            Player.validateStartingRuleGame("GREEN",-12);
        });
        assertEquals("cardNumber must be greater than 0",exception.getMessage(),"Le msg affiché ne correspond pas à celui attendu de l'exception : cas cardNumber<0");
    }
}
