package se.implementer.muaythaiservice.service;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.repository.FighterRepository;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterDetails;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterDto;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterOverview;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterRaw;

@ExtendWith(MockitoExtension.class)
public class FighterServiceTest {

    @Mock
    private FighterRepository fighterRepository;
    ;

    @InjectMocks
    private FighterService fighterService;

    // TODO add error cases

    @Test
    void shouldFetchFighterDetails() {
        var fighterId = 1L;
        when(fighterRepository.findByFighterId(fighterId))
                .thenReturn(Optional.ofNullable(mockFighterRaw(fighterId)));

        var actualValue = fighterService.getFighterDetails(fighterId);

        var expectedValue = mockFighterDetails(fighterId);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldFetchFighterOverview() {
        var fighterId = 1L;
        when(fighterRepository.findByFighterId(fighterId))
                .thenReturn(Optional.ofNullable(mockFighterRaw(fighterId)));

        var actualValue = fighterService.getFighterOverview(fighterId);

        var expectedValue = mockFighterOverview(fighterId);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldFetchListOfFighterOverviewForMaleGender() {
        var fighterId = 1L;
        when(fighterRepository.findAllByFighterStatusAndGender(FighterStatus.ACTIVE.name(), Gender.MALE.name()))
                .thenReturn(List.of(mockFighterRaw(fighterId), mockFighterRaw(fighterId + 1)));

        var actualValue = fighterService.getAllActiveFightersByGender(Gender.MALE);

        var expectedValue = List.of(mockFighterOverview(fighterId), mockFighterOverview(fighterId + 1));

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldAddFighter() {
        var fighterId = 1L;
        when(fighterRepository.save(any()))
                .thenReturn(mockFighterRaw(fighterId));

        var actualValue = fighterService.addFighter(mockFighterDto("Jan"));

        var expectedValue = new Responses.AddFighter(fighterId, "Jan", "Sweden");

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void shouldThrowExceptionWhenCustomerDoesNotExist() {
        var fighterId = 1L;
        when(fighterRepository.findByFighterId(anyLong()))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            fighterService.getFighterDetails(fighterId);
        }).isInstanceOf(ResponseStatusException.class)
                .hasMessageContaining("404 NOT_FOUND \"Fighter with id 1 not found");
    }


}
