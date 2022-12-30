package leh.lehspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러를 구분해주는 어노테이션

public class LehController {

        @GetMapping("hello") //페이지의 자원을 매핑해주는 어노테이션 -> localhost:8080/hello
        //위 자원으로 접근시 아래의 메서드가 실행됨
        public String hello(Model model){

            model.addAttribute("data","hello!");
            return "hello";

        }

}
