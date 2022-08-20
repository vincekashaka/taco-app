package com.example.tacocloud.service;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoOrderService {

    @Autowired
    private OrderRepository orderRepository;

    //customized
    public List<TacoOrder> findDeliveryZip(String deliveryZip){
        return orderRepository.findByDeliveryZip(deliveryZip);
    }

//    public List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(){
//        return orderRepository.readOrdersByDeliveryZipAndPlacedAtBetween(
//                String deliveryZip, Date startDate, Date endDate
//        );
//    }
}
