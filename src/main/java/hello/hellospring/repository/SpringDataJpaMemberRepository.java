package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 스프링 데이터 JPA
 * 리포지토리 인터페이스만으로 개발 완료 가능
 * 기본 CRUD 기능도 제공
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    //Select m from Member m where m.name = ? 으로 자동으로 쿼리를 작성해줌
    Optional<Member> findByName(String name);
}