package com.liuxun.cloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class TestSessionController {
    @GetMapping("/add")
    public Object addSession(HttpSession session){
        Map<String,Object> map = new HashMap<>();
        map.put("name","liuxun");
        map.put("QQ","2652790899");
        map.put("age",25);
        map.put("sessionId",session.getId());
        session.setAttribute("user",map);
        return "add session success";
    }

    @GetMapping("/clear")
    public Object clearSession(HttpSession session){
        session.removeAttribute("user");
        return "clear session success";
    }

    @GetMapping("/show")
    public Object showSession(HttpSession session){

        return session.getAttribute("user");
    }
}
