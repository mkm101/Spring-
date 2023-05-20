package Hello.core.order;

import Hello.core.AppConfig;
import Hello.core.Memberapp;
import Hello.core.Order.Order;
import Hello.core.Order.OrderService;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
}
