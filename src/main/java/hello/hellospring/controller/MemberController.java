package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 스프링 빈으로 자동 등록
 * @Controller, @Service, @Repository 애노테이션을 사용하면 스프링 빈으로 자동 등록됨
 * (@Component를 포함하기 때문에)
 *
 * 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 싱글톤으로 등록
 */
@Controller
public class MemberController {

    private final MemberService memberService;

    //@Autowired : 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌 (DI)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm"; //template에서 해당 html 연결
    }

    @PostMapping(value="/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";    // /로 돌아감
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}