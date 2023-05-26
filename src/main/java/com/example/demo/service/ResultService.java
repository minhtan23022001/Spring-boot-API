package com.example.demo.service;

import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {
    private ResultRepository resultRepository;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

//    public List<ResultDto> getListResult(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//
//        List<Result> results = resultRepository.findByUser_Username(username);
//        return results.stream().map(result -> new ResultDto(result.getId(), null, result.getTotalCorrect() + "/" + result.getTotalQuestion(), dateFormat.format(new Date(result.getCreatedAt().getTime())))).collect(Collectors.toList());
//    }
//
//    public ResultDto getDetailResult(Long id){
//        Result result = resultRepository.findById(id).get();
//        List<QuestionDto> questionDtos = new ArrayList<>();
//        for (DetailResult detailResult : result.getDetailResults()){
//            List<OptionDto> optionDtos = detailResult.getQuestion().getOptions().stream().map(OptionDto::fromEntity).collect(Collectors.toList());
//            QuestionDto questionDto = QuestionDto.fromEntity(detailResult.getQuestion(), detailResult.getSelectedOption(), optionDtos);
//            questionDtos.add(questionDto);
//        }
//
//        ResultDto resultDto = new ResultDto(result.getId(), questionDtos, result.getTotalCorrect() + "/" + result.getTotalQuestion(),
//                dateFormat.format(new Date(result.getCreatedAt().getTime())));
//        return resultDto;
//    }
}
