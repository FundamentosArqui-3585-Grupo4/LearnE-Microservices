package org.learne.platform.learneservice.application.internal.queryservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learne.platform.learneservice.domain.model.aggregates.Exam;
import org.learne.platform.learneservice.domain.model.queries.Exam.GetExamByIdQuery;
import org.learne.platform.learneservice.infrastructure.persistence.jpa.ExamRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamQueryServiceImplTest {

    private ExamRepository examRepository;
    private ExamQueryServiceImpl examQueryService;

    @BeforeEach
    void setUp() {
        examRepository = mock(ExamRepository.class);
        examQueryService = new ExamQueryServiceImpl(examRepository);
    }

    @Test
    void handle_shouldReturnExamById() {
        Exam exam = new Exam(1L);
        when(examRepository.findById(1L)).thenReturn(Optional.of(exam));

        var result = examQueryService.handle(new GetExamByIdQuery(1L));

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void handle_shouldReturnEmptyIfNotFound() {
        when(examRepository.findById(999L)).thenReturn(Optional.empty());

        var result = examQueryService.handle(new GetExamByIdQuery(999L));

        assertTrue(result.isEmpty());
    }
}