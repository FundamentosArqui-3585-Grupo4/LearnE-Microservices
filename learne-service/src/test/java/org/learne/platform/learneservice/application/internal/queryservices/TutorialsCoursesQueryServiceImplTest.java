package org.learne.platform.learneservice.application.internal.queryservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learne.platform.learneservice.domain.model.aggregates.TutorialsCourses;
import org.learne.platform.learneservice.domain.model.queries.TutorialsCourses.GetAllTutorialsCoursesQuery;
import org.learne.platform.learneservice.domain.model.queries.TutorialsCourses.GetTutorialsCoursesByIdQuery;
import org.learne.platform.learneservice.infrastructure.persistence.jpa.TutorialsCoursesRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TutorialsCoursesQueryServiceImplTest {

    private TutorialsCoursesRepository repository;
    private TutorialsCoursesQueryServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(TutorialsCoursesRepository.class);
        service = new TutorialsCoursesQueryServiceImpl(repository);
    }

    @Test
    void handle_shouldReturnTutorialById() {
        TutorialsCourses tutorial = new TutorialsCourses(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(tutorial));

        var result = service.handle(new GetTutorialsCoursesByIdQuery(1L));
        assertTrue(result.isPresent());
    }

    @Test
    void handle_shouldReturnAllTutorials() {
        when(repository.findAll()).thenReturn(List.of(new TutorialsCourses(1L), new TutorialsCourses(2L)));

        var result = service.handle(new GetAllTutorialsCoursesQuery());
        assertEquals(2, result.size());
    }
}