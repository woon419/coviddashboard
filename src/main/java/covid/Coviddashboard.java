package covid;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Coviddashboard_table")
public class Coviddashboard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long reservationId;
        private String name;
        private String reservationDate;
        private String reservationTime;
        private String status;
        private String curedDate;
        private String enterDate;


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
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getReservationDate() {
            return reservationDate;
        }

        public void setReservationDate(String reservationDate) {
            this.reservationDate = reservationDate;
        }
        public String getReservationTime() {
            return reservationTime;
        }

        public void setReservationTime(String reservationTime) {
            this.reservationTime = reservationTime;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public String getCuredDate() {
            return curedDate;
        }

        public void setCuredDate(String curedDate) {
            this.curedDate = curedDate;
        }
        public String getEnterDate() {
            return enterDate;
        }

        public void setEnterDate(String enterDate) {
            this.enterDate = enterDate;
        }

}
