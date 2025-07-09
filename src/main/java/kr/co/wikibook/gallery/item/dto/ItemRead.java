package kr.co.wikibook.gallery.item.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder // 필드의 값들을 간편하게 초기화 하고 인스턴스를 생성할 수 있게 해주는 애너테이션
public class ItemRead {

    private Integer id;
    private String name;
    private String imgPath;
    private Integer price;
    private Integer discountPer;
}
