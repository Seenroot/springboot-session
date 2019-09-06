package com.seenroot.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/session")
public class SessionController {
    @Value("${server.port}")
    private int port;

    @PostMapping(value = "/set")
    public Object setSession(HttpSession session, String name) {
        session.setAttribute("name", name);
        return "ok";
    }

    @GetMapping(value = "/get")
    public Object getSession(HttpSession session) {
        Object name = session.getAttribute("name");
        return "port: " + port + " ,name: " + name;
    }
}
