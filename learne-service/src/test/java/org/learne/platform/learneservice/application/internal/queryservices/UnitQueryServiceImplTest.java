package org.learne.platform.learneservice.application.internal.queryservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learne.platform.learneservice.domain.model.aggregates.Unit;
import org.learne.platform.learneservice.domain.model.queries.Unit.GetAllUnitsQuery;
import org.learne.platform.learneservice.domain.model.queries.Unit.GetUnitByIdQuery;
import org.learne.platform.learneservice.infrastructure.persistence.jpa.UnitRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UnitQueryServiceImplTest {

    private UnitRepository unitRepository;
    private UnitQueryServiceImpl unitQueryService;

    @BeforeEach
    void setUp() {
        unitRepository = mock(UnitRepository.class);
        unitQueryService = new UnitQueryServiceImpl(unitRepository);
    }

    @Test
    void handle_GetAllUnits_ShouldReturnList() {
        when(unitRepository.findAll()).thenReturn(List.of(new Unit(1L)));

        var result = unitQueryService.handle(new GetAllUnitsQuery());

        assertThat(result).hasSize(1);
    }

    @Test
    void handle_GetUnitById_ShouldReturnOptionalUnit() {
        when(unitRepository.findById(5L)).thenReturn(Optional.of(new Unit(5L)));

        var result = unitQueryService.handle(new GetUnitByIdQuery(5L));

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(5L);
    }
}