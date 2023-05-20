package Hello.core;

import Hello.core.Order.Order;
import Hello.core.Order.OrderService;
import Hello.core.discount.DiscountPolicy;
import Hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Memberapp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new Member = "+ memberA.getName());
    }

    public static class OrderServiceImpl implements OrderService {

        private final MemberRepository memberRepository = new MemoryMemberRepository();
        //    /*private final DiscountPolicy discountPolicy = new FixDiscountPolicy();*/
        //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
        private DiscountPolicy discountPolicy;  // 인터페이스에만 의존하도록 코드 변경 (Null pointer Exception)

        @Override
        public Order createOrder(Long memberId, String ItemName, int itemPrice) {
            Member member = memberRepository.findById(memberId);
            int discountPrice = discountPolicy.discount(member,itemPrice);

            return new Order(memberId,ItemName,itemPrice,discountPrice);
        }
    }
}
