package covid;

import covid.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoviddashboardViewHandler {


    @Autowired
    private CoviddashboardRepository coviddashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                Coviddashboard coviddashboard = new Coviddashboard();
                // view 객체에 이벤트의 Value 를 set 함
                coviddashboard.setReservationId(reserved.getId());
                coviddashboard.setName(reserved.getName());
                coviddashboard.setReservationDate(reserved.getReservationDate());
                coviddashboard.setReservationTime(reserved.getReservationTime());

                coviddashboard.setStatus("RESERVED");
                // view 레파지 토리에 save
                coviddashboardRepository.save(coviddashboard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenInspected_then_UPDATE_1(@Payload Inspected inspected) {
        try {
            if (inspected.isMe()) {
                // view 객체 조회
                List<Coviddashboard> coviddashboardList = coviddashboardRepository.findByReservationId(inspected.getReservationId());
                for(Coviddashboard coviddashboard : coviddashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    coviddashboard.setStatus(inspected.getStatus());
                    // view 레파지 토리에 save
                    coviddashboardRepository.save(coviddashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDiagnosed_then_UPDATE_2(@Payload Diagnosed diagnosed) {
        try {
            if (diagnosed.isMe()) {
                // view 객체 조회
                List<Coviddashboard> coviddashboardList = coviddashboardRepository.findByReservationId(diagnosed.getReservationId());
                for(Coviddashboard coviddashboard : coviddashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    coviddashboard.setStatus(diagnosed.getResult());
                    // view 레파지 토리에 save
                    coviddashboardRepository.save(coviddashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenHospitalEntered_then_UPDATE_3(@Payload HospitalEntered hospitalEntered) {
        try {
            if (hospitalEntered.isMe()) {
                // view 객체 조회
                List<Coviddashboard> coviddashboardList = coviddashboardRepository.findByReservationId(hospitalEntered.getReservationId());
                for(Coviddashboard coviddashboard : coviddashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    coviddashboard.setStatus(hospitalEntered.getStatus());
                    coviddashboard.setEnterDate(hospitalEntered.getEnterDate());
                    // view 레파지 토리에 save
                    coviddashboardRepository.save(coviddashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCured_then_UPDATE_4(@Payload Cured cured) {
        try {
            if (cured.isMe()) {
                // view 객체 조회
                List<Coviddashboard> coviddashboardList = coviddashboardRepository.findByReservationId(cured.getReservationId());
                for(Coviddashboard coviddashboard : coviddashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    coviddashboard.setStatus(cured.getStatus());
                    coviddashboard.setCuredDate(cured.getCuredDate());
                    // view 레파지 토리에 save
                    coviddashboardRepository.save(coviddashboard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelled_then_DELETE_1(@Payload Cancelled cancelled) {
        try {
            if (cancelled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                coviddashboardRepository.deleteByReservationId(cancelled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}