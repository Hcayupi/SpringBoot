package com.example.obrestdatajpaDos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public  String holaMundo(){
        return "Hola Mundo que tal vamos!!!!";
    }

    @GetMapping("/bootstrap")
    public String bootstrap(){
        return """
                <!-- Follow these instructions, please! -->
                       <div class="container py-5">
                         <h1 class="h2">Bootstrap v5 Bug Report</h1>
                         <p>Have a bug report to share with us? Use this template to reproduce an isolated test case so we can more easily identify the problem and hopefully find a fix.</p>
                         <p>
                           <a class="btn btn-primary" href="https://github.com/twbs/bootstrap/blob/main/.github/CONTRIBUTING.md#bug-reports" rel="noopener noreferrer" target="_blank">Read bug report guidelines</a>
                         </p>
                         <p>Once you're set, replace the contents of this page and share the link with us in a <a href="https://github.com/twbs/bootstrap/issues/new/choose" rel="noopener noreferrer" target="_blank">new issue</a>.</p>
                         <p>Thanks! <span class="text-danger">♥</span></p>
                       </div>
                       
                """;
    }
}
