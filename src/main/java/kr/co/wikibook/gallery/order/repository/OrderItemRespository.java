package kr.co.wikibook.gallery.order.repository;

import kr.co.wikibook.gallery.order.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRespository extends JpaRepository<OrderItem, Integer> {

    //주문 상품 목록 조회
    List<OrderItem> findByOrderId(Integer orderId);
}
