package se.implementer.muaythaiservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.implementer.muaythaiservice.model.FighterDetails;
import se.implementer.muaythaiservice.model.FighterDto;
import se.implementer.muaythaiservice.model.FighterOverview;
import se.implementer.muaythaiservice.model.Gender;
import se.implementer.muaythaiservice.model.db.FightInfo;
import se.implementer.muaythaiservice.service.FighterService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/muay-thai/fighters")
public class FighterController {

    private final FighterService fighterService;
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @Operation(summary = " Get details about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter found"),
            @ApiResponse(responseCode = "404", description = "Fighter not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/fighter/details/{fighterId}")
    public FighterDetails getFighterDetails(@PathVariable int fighterId) {
        return fighterService.getFighterDetails(fighterId);
    }

    @Operation(summary = " Get overview about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter found"),
            @ApiResponse(responseCode = "404", description = "Fighter not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/fighter/overview/{fighterId}")
    public FighterOverview getFighterOverview(@PathVariable int fighterId) {
        return fighterService.getFighterOverview(fighterId);
    }

    @Operation(summary = " Get overview about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter found"),
            @ApiResponse(responseCode = "404", description = "Fighter not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/active/{gender}")
    public List<FighterOverview> getAllActiveFightersByGender(@PathVariable Gender gender) {
        return fighterService.getAllActiveFightersByGender(gender);
    }

    @Operation(summary = " Get overview about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter history found"),
            @ApiResponse(responseCode = "404", description = "Fighter history not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/fighter/history/{fighterId}")
    public List<FightInfo> getFighterHistory(@PathVariable int fighterId) {

        return fighterService.getFighterHistory(fighterId);
    }

    @Operation(summary = " Add new fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter added"),
            @ApiResponse(responseCode = "404", description = "Fighter not added",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @PostMapping("/fighter")
    public void addFighter(@RequestBody FighterDto fighter) {

        fighterService.addFighter(fighter);
    }

}
