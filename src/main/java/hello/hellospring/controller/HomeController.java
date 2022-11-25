package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * 기본 화면으로 연결
     * 컨트롤러가 정적 파일보다 우선순위가 높음
     */
    @GetMapping("/")
    public String home() {
        return "home";  // home.html 호출
    }
}
