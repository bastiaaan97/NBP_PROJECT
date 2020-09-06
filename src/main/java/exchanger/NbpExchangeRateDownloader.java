package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;


    public class NbpExchangeRateDownloader {

    public NbpExchangeRateResult download(LocalDate forDate) {


        try {

            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/EUR/" + forDate);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return new NbpExchangeRateResult(false,conn.getResponseMessage(),null);



            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            NbpExchangeRateSeries series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);


            conn.disconnect();
            return new NbpExchangeRateResult(true, null, series.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }



}
