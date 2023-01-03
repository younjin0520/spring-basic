package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//스프링 데이터 JPA가 이 인터페이스를 스프링빈으로 자동 등록해줌
//JpaRepository에서 find와 같은 기본 메서드가 모두 제공됨
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    //Select m from Member m where m.name = ? 으로 자동으로 쿼리를 작성해줌
    Optional<Member> findByName(String name);
}
