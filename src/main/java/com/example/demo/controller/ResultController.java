package com.example.demo.controller;

import com.example.demo.entity.question.Question;
import com.example.demo.entity.result.Result;
import com.example.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/getResults")
    public List<Result> getResults() {
        return resultService.getAllResult();
    }

    @GetMapping("/getResult/{id}")
    public Result getResultById(@PathVariable Long id) {
        return resultService.getResultById(id);
    }

    @GetMapping("/topResult")
    public List<Result> getTop10Result() {
        return resultService.getTop10Result();
    }

    @PostMapping("/addResult")
    public Result addResult(@RequestBody Result result) {
        return resultService.addResult(result);
    }


}
