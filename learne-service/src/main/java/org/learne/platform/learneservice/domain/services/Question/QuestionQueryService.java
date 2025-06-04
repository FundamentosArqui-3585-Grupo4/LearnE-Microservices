package org.learne.platform.learneservice.domain.services.Question;

import org.learne.platform.learneservice.domain.model.aggregates.Question;
import org.learne.platform.learneservice.domain.model.queries.Question.GetAllQuestionsQuery;
import org.learne.platform.learneservice.domain.model.queries.Question.GetQuestionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryService {

    Optional<Question> handle(GetQuestionByIdQuery query);

    List<Question> handle(GetAllQuestionsQuery query);
}
