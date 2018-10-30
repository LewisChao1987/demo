package com.example.demo.api;

import com.example.demo.service.RequestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "point/{a}/{b}")
    public  String getPoint(@PathVariable int a,@PathVariable int b){
        return new RequestService().getPoly(a,b);
    }
    public static void main(String[] args) {
        String string = new String("sd");
        System.out.printf(string);

        String string2 = new String("sdsd");
        System.out.printf(string2);
        System.out.println(string2);
    }
}

