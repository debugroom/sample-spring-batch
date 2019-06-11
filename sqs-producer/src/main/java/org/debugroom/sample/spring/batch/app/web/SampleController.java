package org.debugroom.sample.spring.batch.app.web;

import org.debugroom.sample.spring.batch.domain.model.Sample;
import org.debugroom.sample.spring.batch.domain.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SampleController {

    @Autowired
    SampleRepository sampleRepository;

    @GetMapping("/batch")
    public String batch(String message){
        sampleRepository.save(
                Sample.builder()
                        .message(message)
                        .build());
        return "accept";
    }

}
