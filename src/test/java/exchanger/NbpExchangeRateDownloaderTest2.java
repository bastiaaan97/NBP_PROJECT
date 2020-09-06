package exchanger;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class NbpExchangeRateDownloaderTest2 {

    NbpExchangeRateDownloader subject = new NbpExchangeRateDownloader();


    @Test
    
    public void shouldSucessfullyDownloadExchangeRate_whenExchangeDateIsInRange() {
        
        //given
        LocalDate givenExchangeDate = LocalDate.of(2020,9,4);
        
        NbpExchangeRateResult expected = new NbpExchangeRateResult(true,"OK",null);


        //when

        NbpExchangeRateResult actual = subject.download(givenExchangeDate);

        //then

        assertThat(actual.getErrorMessage()).isEqualTo(expected.getErrorMessage());

        assertFalse(actual.isSuccess());

        assertNull(actual.getRate());

        
    }
    
    


}