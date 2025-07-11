package kr.co.wikibook.gallery.order.repository;

import kr.co.wikibook.gallery.order.entity.Order;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //주문 목록 조회
    List<Order> findAllByMemberIdOrderByIdDesc(Integer memberId);

    //주문 정보 조회 (특정아이디 및 특정 회원)
    Optional<Order> findByIdAndMemberId(Integer id, Integer memberId);
}
