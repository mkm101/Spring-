package Hello.core;

import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.member.MemoryMemberRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //@Bean memberService --> new MemoryMemberRepository() 호출
    //@Bean orderService --> new MemoryMemberRepository() 호출
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {

        System.out.println("call AppConfig.memberRepository");
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new discountPolicy();
        return new RateDiscountPolicy();
    }
    @Test
    void configurationDeep() {
        ApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class); //CGLIB 가 상속받아서, APpconfig 튀어나옴.
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
