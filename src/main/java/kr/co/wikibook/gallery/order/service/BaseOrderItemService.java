package kr.co.wikibook.gallery.order.service;

import kr.co.wikibook.gallery.order.entity.OrderItem;
import kr.co.wikibook.gallery.order.repository.OrderItemRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseOrderItemService implements OrderItemService {

    private final OrderItemRespository orderItemRespository;

    //주문 목록 조회
    @Override
    public List<OrderItem> findAll(Integer orderId) {
        return orderItemRespository.findByOrderId(orderId);
    }

    //주문 상품 데이터 저장
    @Override
    public void saveAll(List<OrderItem> orderItems) {
        orderItemRespository.saveAll(orderItems);
    }
}
