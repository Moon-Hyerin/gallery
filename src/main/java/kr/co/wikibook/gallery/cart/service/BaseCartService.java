package kr.co.wikibook.gallery.cart.service;

import kr.co.wikibook.gallery.cart.dto.CartRead;
import kr.co.wikibook.gallery.cart.entity.Cart;
import kr.co.wikibook.gallery.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseCartService implements CartService {

    private final CartRepository cartRepository;

    //장바구니 상품 데이터 목록 조회
    @Override
    public List<CartRead> findAll(Integer memberId) {

        //결괏값을 DTO로 변환 후 리턴
        return cartRepository.findAllByMemberId(memberId).stream().map(Cart::toRead).toList();
    }

    //장바구니 상품 데이터 조회 (특정 회원의 특정 상품)
    @Override
    public CartRead find(Integer memberId, Integer itemId) {
        Optional<Cart> cartOptional = cartRepository.findByMemberIdAndItemId(memberId, itemId);
        //return cartRepository.findByMemberIdAndItemId(memberId, itemId).map(Cart::toRead).orElse(null);
        if(cartOptional.isPresent()) {
            return cartOptional.get().toRead();
        }
        return null;
    }

    @Override
    public void removeAll(Integer memberId) {
        cartRepository.deleteByMemberId(memberId);
    }

    @Override
    public void remove(Integer memberId, Integer itemId) {
        cartRepository.deleteByMemberIdAndItemId(memberId, itemId);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }
}
