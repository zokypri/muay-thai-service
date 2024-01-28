package se.implementer.muaythaiservice.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import se.implementer.muaythaiservice.model.dto.FighterStatus;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.model.dto.response.FighterDetails;
import se.implementer.muaythaiservice.model.dto.response.FighterOverview;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.service.FighterService;
import static se.implementer.muaythaiservice.util.testdata.FighterTestData.mockFighterOverview;
import se.implementer.muaythaiservice.util.testdata.FightsTestData;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.addFighter;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.allActiveFightersByGender;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.baseUrl;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterDetailsURL;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterOverviewURL;

@WebMvcTest(controllers = FighterController.class)
@AutoConfigureMockMvc
public class FighterControllerTest {

    @MockBean
    private FighterService fighterService;

    @Autowired
    private MockMvc mockMvc;

    private static final long fighterID = 11L;

    private static LocalDate BIRTH_DATE = LocalDate.of(2003, 1, 1);

    @Test
    void shouldRespondWithFighterDetails() throws Exception {

        String filePathResponse = "__files/response/FighterDetailsResponse.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        when(fighterService.getFighterDetails(fighterID))
                .thenReturn(mockFighterDetailsFixedDate(fighterID));

        mockMvc.perform(get(baseUrl + fighterDetailsURL, fighterID))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRespondWithFighterOverview() throws Exception {

        String filePathResponse = "__files/response/FighterOverviewResponse.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        when(fighterService.getFighterOverview(fighterID))
                .thenReturn(mockFighterOverview(fighterID));

        mockMvc.perform(get(baseUrl + fighterOverviewURL, fighterID))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());
    }

    @Test
    void shouldRespondWithAllActiveFightersByGender() throws Exception {

        String filePathResponse ="__files/response/ActiveFightersByGenderResponse.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathResponse))
                                .toURI()
                )
        );

        when(fighterService.getAllActiveFightersByGender(Gender.MALE))
                .thenReturn(List.of(mockFighterOverview(fighterID), mockSecondFighterOverview(fighterID + 1)));

        mockMvc.perform(get(baseUrl + allActiveFightersByGender, Gender.MALE))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());
    }

    @Test
    void addFighterToDB() throws Exception {

        String filePathRequest = "__files/request/AddFighterRequest.json";
        String filePathResponse = "__files/response/AddFighterResponse.json";

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

        when(fighterService.addFighter(any()))
                .thenReturn(new Responses.AddFighter(5L, "Zoran", "Sweden"));


        mockMvc.perform(
                        post(baseUrl + addFighter)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

    }

    @Test
    void addFighterGeneralValidationError() throws Exception {

        String filePathRequest = "__files/request/validation/AddFighterGeneralValidationError.json";

        String requestContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );
        mockMvc.perform(
                        post(baseUrl + addFighter)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().string(containsString("with 5 errors")))
                .andExpect(status().isBadRequest());

    }

    @Test
    void addFighterFightsValidationError() throws Exception {

        String filePathRequest = "__files/request/validation/AddFighterFightsValidationError.json";

        String requestContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );
        mockMvc.perform(
                        post(baseUrl + addFighter)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().string(containsString("Fights amount does not add up")))
                .andExpect(status().isBadRequest());
    }

    // TODO test transactional logic or save in DB error for adding fighter?

    private static FighterOverview mockSecondFighterOverview(long fighterId) {
        return FighterOverview
                .builder()
                .fighterId(fighterId)
                .firstName("Allan")
                .lastName("Allison")
                .showName("Al")
                .gender(Gender.MALE)
                .totalFights(10)
                .wins(5)
                .losses(5)
                .age(30)
                .countryOrigin("Spain")
                .status(FighterStatus.ACTIVE)
                .build();
    }

    private static FighterDetails mockFighterDetailsFixedDate(long fighterId) {
        return FighterDetails
                .builder()
                .fighterId(fighterId)
                .fightsInfo(FightsTestData.mockFightInfoDetailsFixedDate(fighterId))
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
                .birthDate(BIRTH_DATE)
                .build();
    }

}
