package covid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoviddashboardRepository extends CrudRepository<Coviddashboard, Long> {

    List<Coviddashboard> findByReservationId(Long reservationId);
    List<Coviddashboard> findByReservationId(Long reservationId);
    List<Coviddashboard> findByReservationId(Long reservationId);
    List<Coviddashboard> findByReservationId(Long reservationId);

        void deleteByReservationId(Long reservationId);
}