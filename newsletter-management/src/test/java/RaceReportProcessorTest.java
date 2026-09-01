import org.algostyle.repport.RaceReportProcessor;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RaceReportProcessorTest {

    @Test
    public void generateReportSuccess() throws Exception {
        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/driver.csv";
        String raceFile = "race/race.csv";

        reportProcessor.generateReport(driverFile,raceFile);
    }
    @Test
    public void generateReportThrowsFileNotFound() throws Exception {
        RaceReportProcessor reportProcessor = new RaceReportProcessor();
        String driverFile = "drivers/drivernotexist.csv";
        String raceFile = "race/race.csv";

        assertThrows(FileNotFoundException.class, ()->{
            reportProcessor.generateReport(driverFile,raceFile);
        });
    }
}
