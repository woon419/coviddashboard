package covid;

public class CoviddashboardReport {
    private Long reserved;
    private Long inspected;
    private Long positive;
    private Long negative;
    private Long entered;
    private Long cured;

    public Long getReserved() {
        return reserved;
    }

    public void setReserved(Long reserved) {
        this.reserved = reserved;
    }

    public Long getInspected() {
        return inspected;
    }

    public void setInspected(Long inspected) {
        this.inspected = inspected;
    }

    public Long getPositive() {
        return positive;
    }

    public void setPositive(Long positive) {
        this.positive = positive;
    }

    public Long getNegative() {
        return negative;
    }

    public void setNegative(Long negative) {
        this.negative = negative;
    }

    public Long getEntered() {
        return entered;
    }

    public void setEntered(Long entered) {
        this.entered = entered;
    }

    public Long getCured() {
        return cured;
    }

    public void setCured(Long cured) {
        this.cured = cured;
    }
}
