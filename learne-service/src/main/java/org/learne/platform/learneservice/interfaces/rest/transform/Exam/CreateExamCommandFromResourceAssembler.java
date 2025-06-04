package org.learne.platform.learneservice.interfaces.rest.transform.Exam;

import org.learne.platform.learneservice.domain.model.commands.Exam.CreateExamCommand;
import org.learne.platform.learneservice.interfaces.rest.resources.Exam.CreateExamResource;

public class CreateExamCommandFromResourceAssembler {

    public static CreateExamCommand ToCommandFromResource(CreateExamResource resource) {
        return new CreateExamCommand(resource.unit_id(), resource.course_id(), resource.title());
    }
}
