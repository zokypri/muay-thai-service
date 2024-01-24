package se.implementer.muaythaiservice.service;

import java.time.LocalDate;
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
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.model.db.Fighter;
import se.implementer.muaythaiservice.model.dto.FightResult;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.model.dto.request.FighterDto;
import se.implementer.muaythaiservice.model.dto.response.FightInfoDetails;
import se.implementer.muaythaiservice.model.dto.response.FighterDetails;
import se.implementer.muaythaiservice.model.dto.response.FighterOverview;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.repository.FighterRepository;

@ExtendWith(MockitoExtension.class)
public class FighterServiceTest {

    @Mock
    private FighterRepository fighterRepository;
    ;

    @InjectMocks
    private FighterService fighterService;

    private static final String BKK = "BKK";
    private static final String RAJA = "RAJA";
    private static final String MAX = "MAX";
    private static final String PATT = "Pattaya";

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

    private FighterDto mockFighterDto(String firstName) {
        return FighterDto
                .builder()
                .firstName(firstName)
                .lastName("Banan")
                .showName("Banane")
                .height("177")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .status(FighterStatus.ACTIVE)
                .birthDate(LocalDate.now().minusYears(20))
                .build();
    }

    private FighterOverview mockFighterOverview(long fighterId) {
        return FighterOverview
                .builder()
                .fighterId(fighterId)
                .firstName("Jan")
                .lastName("Banan")
                .showName("Banane")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .age(20)
                .countryOrigin("Sweden")
                .status(FighterStatus.ACTIVE)
                .build();
    }

    private FighterDetails mockFighterDetails(long fighterId) {
        return FighterDetails
                .builder()
                .fighterId(fighterId)
                .fightsInfo(mockFightInfoDetails(fighterId, 1L))
                .firstName("Jan")
                .lastName("Banan")
                .showName("Banane")
                .height("177")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .age(20)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .status(FighterStatus.ACTIVE)
                .birthDate(LocalDate.now().minusYears(20))
                .build();
    }

    private List<FightInfoDetails> mockFightInfoDetails(long fighterId, long fightId) {
        return List.of(
                FightInfoDetails
                        .builder()
                        .fightId(fightId)
                        .fighterId(fighterId)
                        .result(FightResult.WIN)
                        .opponentId(-1)
                        .fightDay(LocalDate.now().minusDays(7))
                        .location(BKK)
                        .arena(RAJA)
                        .weight("65")
                        .fightOrg(RAJA)
                        .build(),
                FightInfoDetails
                        .builder()
                        .fightId(fightId + 1)
                        .fighterId(fighterId)
                        .result(FightResult.DRAW)
                        .opponentId(-1)
                        .fightDay(LocalDate.now().minusDays(3))
                        .location(PATT)
                        .arena(MAX)
                        .weight("65")
                        .fightOrg(MAX)
                        .build()
        );
    }

    private Fighter mockFighterRaw(long fighterId) {
        return Fighter
                .builder()
                .fighterId(fighterId)
                .fightsInfo(mockFightsInfo(fighterId, 1L))
                .firstName("Jan")
                .lastName("Banan")
                .stageName("Banane")
                .height("177")
                .gender("MALE")
                .totalFights(10)
                .wins(7)
                .losses(2)
                .draws(1)
                .countryOrigin("Sweden")
                .countryLiving("Thailand")
                .club("Fairtex")
                .birthDate(LocalDate.now().minusYears(20))
                .fighterStatus("ACTIVE")
                .build();
    }

    private List<FightInfo> mockFightsInfo(long fighterId, long fightId) {
        return List.of(
                FightInfo
                        .builder()
                        .fightId(fightId)
                        .fighterId(fighterId)
                        .result(FightResult.WIN.name())
                        .opponentId(-1)
                        .fightDay(LocalDate.now().minusDays(7))
                        .location(BKK)
                        .arena(RAJA)
                        .weight("65")
                        .fightOrg(RAJA)
                        .build(),
                FightInfo
                        .builder()
                        .fightId(fightId + 1)
                        .fighterId(fighterId)
                        .result(FightResult.DRAW.name())
                        .opponentId(-1)
                        .fightDay(LocalDate.now().minusDays(3))
                        .location(PATT)
                        .arena(MAX)
                        .weight("65")
                        .fightOrg(MAX)
                        .build()
        );
    }
}
