package org.learne.platform.learneservice.interfaces.rest.resources.TutorialsCourses;

public record TutorialsCoursesResource(Long id, Long courses_id, Long teacher_id, String date,
                                       String hour, Boolean is_reservated, String link) {
}
