package org.example.hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "Hello POST World";
    }

    @GetMapping("/hello/json")
    public Map<String, String> helloJson() {
        return Map.of("get", "Hello World!", "post", "Hello POST World!");
    }

    @PostMapping("/hello/json")
    public Map<String, String> helloJsonPost() {
        return Map.of("get", "Hello World!", "post", "Hello POST World!");
    }

    @GetMapping("/hello/name")
    public String helloName(@RequestParam("name") String name) {
        return "Hello," + name + "!";
    }

    @PostMapping("/hello/name")
    public String helloNamePost(@RequestParam("name") String name) {
        return "Hello," + name + "!";
    }

    @PostMapping("/hello/name/json")
    public String helloNameJson(@RequestBody Map<String,String> name) {
        return "Hello," + name.get("name") + "!";
    }
}
