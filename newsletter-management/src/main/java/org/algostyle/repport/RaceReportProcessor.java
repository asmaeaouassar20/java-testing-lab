package org.algostyle.repport;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class RaceReportProcessor {

    public void generateReport(String driverFileLocation, String racePerformanceLocation) throws Exception{
        // lire 2 fichiers et combiner les
        FileInputStream driverInputStream = new FileInputStream(driverFileLocation);
        List<Driver> driverList = readFileToObjectList(driverInputStream);

        FileInputStream racePerformanceInputStream = new FileInputStream(racePerformanceLocation);
        List<RacePerformance> racePerformanceList = readFileToObjectList(racePerformanceInputStream);

        // combines data
        combineDriverAndRaceToReport(driverList,racePerformanceList);
    }

    private void combineDriverAndRaceToReport(List<Driver> driverList, List<RacePerformance>racePerformance){
        // combine tw reports into one and save it
    }

    <T> List<T> readFileToObjectList(FileInputStream driverFile) throws IOException, ClassNotFoundException{
        return new ArrayList<>();
    }
}
