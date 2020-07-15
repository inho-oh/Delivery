package usedbookstore;

import usedbookstore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired DeliveryRepository DeliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPurchased_Request(@Payload Purchased purchased){

        if(purchased.isMe()){
            System.out.println("##### listener Request : " + purchased.toJson());
            Delivery delivery = new Delivery();

            delivery.setPurchaseid(purchased.getId());
            delivery.setStatus("배송요청");
            DeliveryRepository.save(delivery);

        }
    }

}
