package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hi")
    public String hello(Model model){ //model은 반드시 추가
        model.addAttribute("data", "hello~@!"); //data에  hello넣는거

        return "hi"; // html주소가 이름
    }

    @GetMapping("test")
    public String print(@RequestParam(value = "number")String number, Model model){ //html반환 시 model은 반드시 추가
        model.addAttribute("number", number); //data에  hello넣는거

        return "test"; // html주소가 이름
    }

    @GetMapping("json") // 뷰를 통한것이 아닌 바로 http바디에 통으로 문자반환
    @ResponseBody
    public String json(@RequestParam(value = "number")String number){
        return "gimozzi" + number; // api_test + '$name'
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam(value = "string") String ex){
        Hello hello = new Hello();
        hello.setName(ex);
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
