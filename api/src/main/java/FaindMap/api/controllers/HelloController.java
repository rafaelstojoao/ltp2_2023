
package FaindMap.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faindmap")
public class HelloController {
    
    @GetMapping
    public String olaMundo(){
        return "Bem vindo ao FaindMap";
    }
}
