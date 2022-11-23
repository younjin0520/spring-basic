package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JUnit 프레임워크를 이용해서 테스트
 * 테스트 class의 이름은 관례적으로 main class 이름 + Test
 * main 메서드처럼 작성하면 됨
 */
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 함수가 끝날때마다 실행됨
    // 한 번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남아서 실패할 수 있으므로 메모리 DB에 저장된 데이터 삭제
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("John");
        member2.setName("Josh");
        repository.save(member1);
        repository.save(member2);

        //when - 테스트하려고 하는 부분
        Member result = repository.findByName(member1.getName()).get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}
