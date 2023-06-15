package Hello.core.Order;

import Hello.core.member.MemberRepository;
import Hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages =  "hello.core.member",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

        public class AutoAppConfig { // 아무것도 없는데 component 키워드를 이용하면 자동으로 빈으로 등록`

        @Bean(name = "memoryMemberRepository")
        MemberRepository memberRepository() {
                return new MemoryMemberRepository();
        }
}
