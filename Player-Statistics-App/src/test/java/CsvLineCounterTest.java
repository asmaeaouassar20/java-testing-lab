import org.algostyle.CsvLineCounter;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvLineCounterTest {
    @Test
    public void countLines() throws IOException{
        File file = new File("./test.csv");
        String csvData = "a,b,c\nd,e,f\ng";
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(csvData);
        bw.close();

        long actualLines = CsvLineCounter.countLinesFromFile(file.toPath());
        assertEquals(3,actualLines);
    }
}
