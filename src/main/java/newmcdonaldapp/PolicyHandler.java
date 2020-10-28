package newmcdonaldapp;

import newmcdonaldapp.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    StoreManagementRepository storeManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApprove_OrderStack(@Payload PayApprove payApprove){

        if(payApprove.isMe()){
            System.out.println("##### listener OrderStack : " + payApprove.toJson());

            StoreManagement storeManagement = new StoreManagement();
            storeManagement.setOrderId(payApprove.getOrderId());

            storeManagementRepository.save(storeManagement);
        }
    }

}
