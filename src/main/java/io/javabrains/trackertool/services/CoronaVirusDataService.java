package io.javabrains.trackertool.services;

import io.javabrains.trackertool.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {
    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        return this.allStats;
    }

    // this basically tell Spring when you construct instance of this service, after it's done, just execute this method ok
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        // this HttpRequest allow us to use the Builder's pattern
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL)) // create a URI out of it
                .build();
        // get the response by sending this request to the client
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response.body());

        StringReader csvBodyReader = new StringReader(response.body());
        CSVFormat meo = CSVFormat.DEFAULT
                .builder()
                .setHeader("Province/State", "Country/Region")
                .setSkipHeaderRecord(true)
                .build();
        CSVParser parser = new CSVParser(csvBodyReader, meo);
        Iterable<CSVRecord> records = parser.getRecords();

        List<LocationStats> newStats = new ArrayList<>();
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            locationStat.setLastedTotalCases(Integer.parseInt(record.get(record.size() - 1)));

//            System.out.println(locationStat);
            newStats.add(locationStat);
        }

        this.allStats = newStats;
    }
}
