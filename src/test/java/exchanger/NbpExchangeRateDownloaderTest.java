package exchanger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NbpExchangeRateDownloaderTest {

    NbpExchangeRateDownloader subject = new NbpExchangeRateDownloader();

    @Test

    public void shouldSucessfullyDownloadExchangeRate_whenExchangeDateIsInRange() {

        //given
        LocalDate givenExchangeDate = LocalDate.of(2070, 9, 28);

        NbpExchangeRateResult expected = new NbpExchangeRateResult(false,"B³êdny zakres dat / Invalid date range",null);

        //when

        NbpExchangeRateResult actual = subject.download(givenExchangeDate);

        //then

        assertThat(actual.getErrorMessage()).isEqualTo(expected.getErrorMessage());

        assertFalse(actual.isSuccess());

        assertNull(actual.getRate());
        }


    }
