package com.example.demo.service;

import com.example.demo.entity.result.Result;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    public List<Result> getAllResult() {
        return resultRepository.findAll();
    }

    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    public List<Result> getTop10Result() {
        ArrayList<Result> list = new ArrayList<Result>();
        list.addAll(resultRepository.findAll());
        Collections.sort(list, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                if (o1.getTotalMoney() < o2.getTotalMoney()) {
                    return 1;
                } else {
                    if(o1.getTotalMoney() == o2.getTotalMoney()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        ArrayList<Result> top10List = new ArrayList<Result>();
        for (int i = 0; i < list.size(); i++) {
            if(i<10) {
                top10List.add(list.get(i));
            }
        }
        return top10List;
    }

    public Result addResult(Result result) {
        return resultRepository.save(result);
    }
}
