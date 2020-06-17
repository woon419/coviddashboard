package covid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoviddashboardController {
    @Autowired
    private CoviddashboardRepository coviddashboardRepository;

    @GetMapping("/coviddashboards/report")
    public CoviddashboardReport getReport(){
        Long reserved = coviddashboardRepository.countByStatus("RESERVED");
        Long inspected = coviddashboardRepository.countByStatus("INSPECTED");
        Long positive = coviddashboardRepository.countByStatus("POSITIVE");
        Long negative = coviddashboardRepository.countByStatus("NEGATIVE");
        Long entered = coviddashboardRepository.countByStatus("ENTERED");
        Long cured = coviddashboardRepository.countByStatus("CURED");

        CoviddashboardReport report = new CoviddashboardReport();
        report.setReserved(reserved);
        report.setInspected(inspected);
        report.setPositive(positive);
        report.setNegative(negative);
        report.setEntered(entered);
        report.setCured(cured);

        return report;
    }
}
