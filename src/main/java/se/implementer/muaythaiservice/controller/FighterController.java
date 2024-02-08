package se.implementer.muaythaiservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.implementer.muaythaiservice.model.dto.response.FighterDetails;
import se.implementer.muaythaiservice.model.dto.request.FighterDto;
import se.implementer.muaythaiservice.model.dto.response.FighterOverview;
import se.implementer.muaythaiservice.model.dto.Gender;
import se.implementer.muaythaiservice.model.dto.response.Responses;
import se.implementer.muaythaiservice.service.FighterService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/fighters")
public class FighterController {

    //TODO split controllers between external user and backoffice user
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
    public FighterDetails getFighterDetails(@PathVariable long fighterId) {
        log.info("Receiving request to fetch details for fighter with id: {}", fighterId);
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
    public FighterOverview getFighterOverview(@PathVariable long fighterId) {
        log.info("Receiving request to fetch overview for fighter with id: {}", fighterId);
        return fighterService.getFighterOverview(fighterId);
    }

    @Operation(summary = " Get overview about one fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter found"),
            @ApiResponse(responseCode = "404", description = "Fighter not found",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @GetMapping("/fighter/active/{gender}")
    public List<FighterOverview> getAllActiveFightersByGender(@PathVariable Gender gender) {
        log.info("Receiving request to fetch all active fighters of the gender: {}", gender);
        return fighterService.getAllActiveFightersByGender(gender);
    }

    @Operation(summary = " Add new fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter added"),
            @ApiResponse(responseCode = "404", description = "Fighter not added",
                    content = @Content)
    })
    @SecurityRequirement(name ="Bearer Auth")
    @PostMapping("/fighter")
    public Responses.AddFighter addFighter(@Valid @RequestBody FighterDto fighter) {
        log.info("Receiving request to add a new fighter to the DB");
        return fighterService.addFighter(fighter);
    }

}
