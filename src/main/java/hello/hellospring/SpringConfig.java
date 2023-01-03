package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * 컴포넌트 스캔 방식 대신 자바 코드로 스프링 빈 설정
 */
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
 //   private final DataSource dataSource;
 //   private final EntityManager em;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

 //   @Bean
 //   public MemberRepository memberRepository() {
 //       return new JpaMemberRepository(em);
 //   }
}
