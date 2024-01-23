package se.implementer.muaythaiservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.implementer.muaythaiservice.model.dto.request.FightInfoDto;
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.service.FightService;

@Slf4j
@RestController
@RequestMapping("v1/muay-thai/fights")
public class FightController {

    private final FightService fightService;
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }


    @Operation(summary = " Get overview about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter history found"),
            @ApiResponse(responseCode = "404", description = "Fighter history not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/fighter/history/{fighterId}")
    public List<FightInfo> getFighterHistory(@PathVariable long fighterId) {
        log.info("Receiving request to fetch all fight history for fighter with id: {}", fighterId);
        return fightService.getFighterHistory(fighterId);
    }

    @Operation(summary = " Add new fight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fight added"),
            @ApiResponse(responseCode = "404", description = "Fight not added",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @PostMapping("/fight")
    public Responses.AddFight addFight(@Valid @RequestBody FightInfoDto fightInfoDto) {
        log.info("Receiving request to add a fighter for fighter with id: {}", fightInfoDto.getFighterId());
        return fightService.addFight(fightInfoDto);
    }

}
