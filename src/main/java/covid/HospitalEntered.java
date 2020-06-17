package covid;

public class HospitalEntered extends AbstractEvent {

    private Long id;
    private Long reservationId;
    private String status;
    private String enterDate;
    private String curedDate;
    private Long hospitalId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
    public String getCuredDate() {
        return curedDate;
    }

    public void setCuredDate(String curedDate) {
        this.curedDate = curedDate;
    }
    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }
}