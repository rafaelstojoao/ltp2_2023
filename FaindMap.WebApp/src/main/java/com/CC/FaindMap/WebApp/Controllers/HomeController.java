package com.CC.FaindMap.WebApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Index() {
        return "Home/Index";
    }

    @GetMapping("/buscar")
    public String Buscar() {
        return "Home/Buscar";
    }

    @GetMapping("/rota")
    public RedirectView Rota() {
        return new RedirectView("/buscar");
    }

    @PostMapping("/rota")
    public String Rota(@RequestParam int idOrigem, @RequestParam int idDestino) {
        return "Home/Rota";
    }
}
