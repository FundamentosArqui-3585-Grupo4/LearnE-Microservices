package org.learne.platform.learneservice.application.internal.queryservices;

import org.learne.platform.learneservice.domain.model.aggregates.Question;
import org.learne.platform.learneservice.domain.model.queries.Question.GetAllQuestionsQuery;
import org.learne.platform.learneservice.domain.model.queries.Question.GetQuestionByIdQuery;
import org.learne.platform.learneservice.domain.services.Question.QuestionQueryService;
import org.learne.platform.learneservice.infrastructure.persistence.jpa.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {

    private final QuestionRepository questionRepository;

    public QuestionQueryServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Optional<Question> handle(GetQuestionByIdQuery query) {
        return questionRepository.findById(query.id());
    }

    @Override
    public List<Question> handle(GetAllQuestionsQuery query) {
        return questionRepository.findAll();
    }
}
