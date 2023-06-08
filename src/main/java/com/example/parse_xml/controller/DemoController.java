package com.example.parse_xml.controller;

import com.example.parse_xml.pojo.DemoModel;
import com.example.parse_xml.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/get")
    public ResponseEntity getDemo(){
        DemoModel demoModel = demoService.parseXml();
        return ResponseEntity.status(200).body(demoModel);
    }
}
