package kr.co.wikibook.gallery.item.entity;

import jakarta.persistence.*;
import kr.co.wikibook.gallery.item.dto.ItemRead;
import lombok.Cleanup;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer discountPer;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    //상품 조회 DTO로 변환
    public ItemRead toRead(){
        //엔티티 객체를 상품조회 DTO(ItemRead)로 변환하는 메서드
        //빌더를 활용해 필드의 값을 간편하게 초기화 하고 객체를 생성
        // 이 메서드는 추후 상품 서비스에서 데이터를 조회할때 사용
        return ItemRead.builder()
                .id(id)
                .name(name)
                .imgPath(imgPath)
                .price(price)
                .discountPer(discountPer)
                .build();
    }
}
