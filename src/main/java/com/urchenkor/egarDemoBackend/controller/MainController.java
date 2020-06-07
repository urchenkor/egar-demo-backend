package com.urchenkor.egarDemoBackend.controller;

import com.urchenkor.egarDemoBackend.entity.Subject;
import com.urchenkor.egarDemoBackend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class MainController {

    private SubjectService subjectService;

    @Autowired
    public MainController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjectList() {
        return subjectService.getList();
    }

    @PostMapping
    public HttpStatus createSubject(@RequestBody Subject subject) {
            if (subjectService.createSubject(subject)) {
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PutMapping
    public HttpStatus updateSubject(@RequestBody Subject subject) {
        if (subjectService.updateSubject(subject)) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
