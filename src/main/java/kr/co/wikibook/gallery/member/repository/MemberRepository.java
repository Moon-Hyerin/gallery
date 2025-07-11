package kr.co.wikibook.gallery.member.repository;

import kr.co.wikibook.gallery.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    //JPA 인터페이스 확장 : 제네릭 매개변수로 회원 엔티티 member와 이 엔티티 아이디의 데이터 타입인 Integer를 지정

    //아이디와 패스워드로 회원 정보를 조회
    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
}
