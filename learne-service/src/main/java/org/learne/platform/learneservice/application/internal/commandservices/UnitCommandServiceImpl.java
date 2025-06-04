package org.learne.platform.learneservice.application.internal.commandservices;

import org.learne.platform.learneservice.domain.model.aggregates.Unit;
import org.learne.platform.learneservice.domain.model.commands.Unit.CreateUnitCommand;
import org.learne.platform.learneservice.domain.services.Unit.UnitCommandService;
import org.learne.platform.learneservice.infrastructure.persistence.jpa.UnitRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitCommandServiceImpl implements UnitCommandService {
    private final UnitRepository unitRepository;
    public UnitCommandServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    @Override
    public Long handle(CreateUnitCommand command) {
        var newUnit = new Unit(command);

        try {
            unitRepository.save(newUnit);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("An error occurred while saving a new unit: " + e.getMessage());
        }

        return newUnit.getId();
    }
}
