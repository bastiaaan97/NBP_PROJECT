package exchanger;

import java.math.BigDecimal;

public class NbpExchangeRateResult {
    public NbpExchangeRateResult(boolean success, String errorMessage, BigDecimal rate) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.rate = rate;
    }

    private boolean success;
    private String errorMessage;
    private BigDecimal rate;

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
