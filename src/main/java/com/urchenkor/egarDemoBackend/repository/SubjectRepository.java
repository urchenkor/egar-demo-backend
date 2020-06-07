package com.urchenkor.egarDemoBackend.repository;

import com.urchenkor.egarDemoBackend.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository <Subject, Long> {
    Optional<Subject> findByTool(String tool);
}
