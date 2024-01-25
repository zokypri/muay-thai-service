package se.implementer.muaythaiservice.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.repository.FightInfoRepository;
import se.implementer.muaythaiservice.util.testdata.FightsTestData;
import static se.implementer.muaythaiservice.util.testdata.FightsTestData.mockFightInfoDetails;

@ExtendWith(MockitoExtension.class)
public class FightServiceTest {

    @Mock
    private FightInfoRepository fightInfoRepository;

    @InjectMocks
    private FightService fightService;

    @Test
    void shouldReturnFighterHistory() {
        var fightId = 1L;
        when(fightInfoRepository.findAllByFighterId(fightId)).thenReturn(FightsTestData.mockFightsInfo(fightId));

        var actualResult = fightService.getFighterHistory(fightId);

        var expectedResult = mockFightInfoDetails(fightId);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldReturnEmptyList() {
        var fightId = 1L;
        when(fightInfoRepository.findAllByFighterId(fightId)).thenReturn(List.of());

        var actualResult = fightService.getFighterHistory(fightId);

        var expectedResult = List.of();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldAddFightInfo() {
        var fighterId = 1L;
        var fightInfo = FightsTestData.mockFightsInfo(fighterId).get(0);
        when(fightInfoRepository.save(any())).thenReturn(fightInfo);

        var actualResult = fightService.addFight(FightsTestData.mockFightInfoDto(fighterId));

        var expectedResult = new Responses.AddFight(1L, fighterId);

        assertEquals(expectedResult, actualResult);
    }

}
