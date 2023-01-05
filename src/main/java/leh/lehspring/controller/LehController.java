package leh.lehspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러를 구분해주는 어노테이션

public class LehController {

        @GetMapping("hello") //페이지의 자원을 매핑해주는 어노테이션 -> localhost:8080/hello
        //위 자원으로 접근시 아래의 메서드가 실행됨
        public String hello(Model model){

            model.addAttribute("data","hello!");
            return "hello";

        }

        @GetMapping("hello-mvc")
        public String helloMvc (@RequestParam("name") String name, Model model){ //변수를 사용자의 파라미터로 받기

            model.addAttribute("name",name);
            return "hello-template";
        }

        @GetMapping("hello-string")
        @ResponseBody
        public String helloString(@RequestParam("name") String name){

            return "hello"+name;
        }

        @GetMapping("hello-api")
        @ResponseBody
        public Hello helloApi(@RequestParam("name") String name){
            Hello hello = new Hello();
            hello.setName(name);
            return hello;
        }

        static class Hello{

            private String name;
            public String getName(){
                return name;
            }
            public void setName(String name){
                this.name = name;
            }
        }


}
