package se.implementer.muaythaiservice.component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.repository.FightInfoRepository;
import se.implementer.muaythaiservice.repository.FighterRepository;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.addFight;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.addFighter;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.allActiveFightersByGender;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.baseUrlFightInfo;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.baseUrlFighter;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fightHistory;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterDetailsURL;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterOverviewURL;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MuayThaiIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FighterRepository fighterRepository;

    @Autowired
    private FightInfoRepository fightInfoRepository;

    @Test
    void shouldFetchFighterOverview() throws Exception {

        var fighterId = 8888L;

        String filePathResponse = "__files/component/response/FighterOverview.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(get(baseUrlFighter + fighterOverviewURL, fighterId))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFetchFighterDetails() throws Exception {

        var fighterId = 8888L;

        String filePathResponse = "__files/component/response/FighterDetails.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(get(baseUrlFighter + fighterDetailsURL, fighterId))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFetchFActiveFightersByGender() throws Exception {

        String filePathResponse = "__files/component/response/ActiveFightersByGender.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(get(baseUrlFighter + allActiveFightersByGender, Gender.FEMALE))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

        // TODO figure out how to fix the age otherwise the test will fail each time a birthday is had
    }

    @Test
    void shouldAddFighter() throws Exception {

        String filePathRequest = "__files/component/request/AddFighter.json";
        String filePathResponse = "__files/component/response/AddFighter.json";

        String requestContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(
                        post(baseUrlFighter + addFighter)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

        var fighter = fighterRepository.findByFighterId(1);

        assertTrue(fighter.isPresent());
        assertEquals(1, fighter.get().getFighterId());
        assertEquals("Zoran", fighter.get().getFighterStatus());
        assertEquals(6, fighter.get().getTotalFights());
        assertEquals(5, fighter.get().getWins());
        assertEquals(1, fighter.get().getLosses());
        assertEquals("Zoky", fighter.get().getStageName());
        assertEquals("None", fighter.get().getClub());
        assertEquals("ACTIVE", fighter.get().getFighterStatus());
        assertEquals("MALE", fighter.get().getGender());
    }

    @Test
    void shouldThrowFighterNotFound() throws Exception {

        var fighterId = 99;

        mockMvc.perform(get(baseUrlFighter + fighterOverviewURL, fighterId))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Fighter with id 99 not found")));
    }

    @Test
    void shouldRespondWithFightHistory() throws Exception {

        var fighterId = 8888L;

        String filePathResponse = "__files/component/response/FightHistory.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(get(baseUrlFightInfo + fightHistory, fighterId))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

        var fightHistory = fightInfoRepository.findAllByFighterId(fighterId);

        assertFalse(fightHistory.isEmpty());

        assertEquals(3, fightHistory.size());
        assertEquals(334, fightHistory.get(0).getFightId());
        assertEquals("WIN", fightHistory.get(0).getResult());
    }

    @Test
    void shouldRespondWithEmptyListWhenNoFightsForFighter() throws Exception {

        var fighterId = 555;

        mockMvc.perform(get(baseUrlFightInfo + fightHistory, fighterId))
                .andExpect(status().isOk());

        var fightHistory = fightInfoRepository.findAllByFighterId(fighterId);

        assertTrue(fightHistory.isEmpty());
    }

    @Test
    void shouldAddFight() throws Exception {

        String filePathRequest = "__files/request/AddFight.json";
        String filePathResponse = "__files/response/AddFightResponse.json";

        String requestContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        mockMvc.perform(
                        post(baseUrlFightInfo + addFight)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

        var fights = fightInfoRepository.findAllByFighterId(11L);

        assertFalse(fights.isEmpty());

    }
}
