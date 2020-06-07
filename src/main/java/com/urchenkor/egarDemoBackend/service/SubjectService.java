package com.urchenkor.egarDemoBackend.service;

import com.urchenkor.egarDemoBackend.entity.Subject;
import com.urchenkor.egarDemoBackend.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<List<Subject>> getList() {
        List<Subject> subjects = subjectRepository.findAll();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    public boolean createSubject(Subject subject) {
        subjectRepository.save(subject);
        return true;
    }

    public boolean updateSubject(Subject subject) {
        Optional<Subject> subjectFromDb = subjectRepository.findById(subject.getId());
        if (subjectFromDb.isPresent()) {
            Subject subj = subjectFromDb.get();
            subj.setDate(subject.getDate());
            subj.setCost(subject.getCost());
            subj.setTool(subject.getTool());
            subjectRepository.save(subj);
            return true;
        }
        return false;
    }

}
