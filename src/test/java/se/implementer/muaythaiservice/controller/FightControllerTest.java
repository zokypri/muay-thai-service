package se.implementer.muaythaiservice.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
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
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.service.FightService;
import static se.implementer.muaythaiservice.util.testdata.FightsTestData.mockFightInfoDetailsFixedDate;

@WebMvcTest(controllers = FightController.class)
@AutoConfigureMockMvc
public class FightControllerTest {

    @MockBean
    private FightService fightService;

    @Autowired
    private MockMvc mockMvc;

    private static final String baseUrl = "/v1/fights";

    private static final String fightHistory = "/fight/history/{fighterId}";

    private static final String addFight = "/fight";

    @Test
    void shouldRespondWithFightHistory() throws Exception {

        String filePathRequest = "__files/response/FightHistoryResponse.json";

        String responseContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );

        var fighterID = 11L;
        when(fightService.getFightHistory(fighterID))
                .thenReturn(mockFightInfoDetailsFixedDate(fighterID));

        mockMvc.perform(get(baseUrl + fightHistory, fighterID))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

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

        var fighterID = 11L;
        when(fightService.addFight(any()))
                .thenReturn(new Responses.AddFight(1L, fighterID));

        mockMvc.perform(
                        post(baseUrl + addFight)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

    }

    @Test
    void shouldAThrowValidationError() throws Exception {

        String filePathRequest = "__files/request/validation/AddFightValidationError.json";

        String requestContent = Files.readString(
                Paths.get(
                        Objects.requireNonNull(getClass().getClassLoader().getResource(filePathRequest))
                                .toURI()
                )
        );

        mockMvc.perform(
                        post(baseUrl + addFight)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestContent))
                .andExpect(content().string(containsString("with 2 errors:")))
                .andExpect(status().isBadRequest());

    }
}
