package se.implementer.muaythaiservice.component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import se.implementer.muaythaiservice.model.dto.Gender;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.allActiveFightersByGender;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.baseUrl;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterDetailsURL;
import static se.implementer.muaythaiservice.util.testdata.TEST_URL.fighterOverviewURL;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MuayThaiIT {

    @Autowired
    private MockMvc mockMvc;

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

        mockMvc.perform(get(baseUrl + fighterOverviewURL, fighterId))
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

        mockMvc.perform(get(baseUrl + fighterDetailsURL, fighterId))
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

        mockMvc.perform(get(baseUrl + allActiveFightersByGender, Gender.FEMALE))
                .andExpect(content().json(responseContent))
                .andExpect(status().isOk());

        // TODO figure out how to fix the age otherwise the test will fail each time a birthday is had
    }

    @Test
    void shouldThrowFighterNotFound() throws Exception {

        var fighterId = 99;

        mockMvc.perform(get(baseUrl + fighterOverviewURL, fighterId))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Fighter with id 99 not found")));
    }
}
