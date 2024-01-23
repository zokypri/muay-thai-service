package se.implementer.muaythaiservice.model.dto.response;

public class Responses {

    public record AddFighter(Long fighterId, String name, String country){}

    public record AddFight(Long fightId , Long fighterId){}
}
