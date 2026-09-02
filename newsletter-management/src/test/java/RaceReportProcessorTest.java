import com.googlecode.catchexception.CatchException;
import org.algostyle.repport.RaceReportProcessor;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static  com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.jupiter.api.Assertions.*;

public class RaceReportProcessorTest {

    @Test
    public void generateReportSuccess() throws Exception {
        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/driver.csv";
        String raceFile = "race/race.csv";

        reportProcessor.generateReport(driverFile,raceFile);
    }
    @Test
    public void generateReportThrowsFileNotFound()  {
        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/drivernotexist.csv";
        String raceFile = "race/race.csv";

        assertThrows(FileNotFoundException.class, ()->{
            reportProcessor.generateReport(driverFile,raceFile);
        });
    }

    // use catch exception
    @Test
    public void generateReportThrowsFileNotFoundCatchException() throws Exception {
        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/drivernotexist.csv";
        String raceFile = "race/race.csv";

        catchException(()->reportProcessor.generateReport(driverFile,raceFile));
        assertTrue(caughtException() instanceof FileNotFoundException);
        assertEquals("drivers\\drivernotexist.csv (Le fichier spécifié est introuvable)", caughtException().getMessage());
    }
}
