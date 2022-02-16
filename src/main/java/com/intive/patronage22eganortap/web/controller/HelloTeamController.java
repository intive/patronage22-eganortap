package com.intive.patronage22eganortap.web.controller;

import com.intive.patronage22eganortap.model.TeamMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
@Deprecated
@Tag(name = "TeamMembers", description = "Demo endpoints") //const String
public class HelloTeamController {
    private static final String GROUP_TAG = "TeamMembers";
    private List<TeamMember> members = createList();


    @Deprecated(forRemoval = true)
    @GetMapping("/hello")
    public String hello() {
        return "Hello Cebularze Team:)";
    }

    @Deprecated
    @GetMapping("/members")
    public List<TeamMember> listAll() {
        return members;
    }

    @Deprecated
    @PostMapping("/members/create")
    @Operation(summary = "Adding TeamMember", tags = {GROUP_TAG})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added teamMember",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TeamMember.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not Acceptable", responseCode = "406", content = @Content),
            @ApiResponse(description = "Internal error", responseCode = "500", content = @Content),
    })
    public TeamMember create(@Valid @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody TeamMember member) {
        members.add(member);
        return member;
    }

    @Deprecated
    @DeleteMapping("members/delete/{id}")
    public ResponseEntity<TeamMember> deleteMember(@PathVariable Long id) {
        TeamMember memberTmp = null;
        for (TeamMember member : members) {
            if (member.getId() == id) {
                members.remove(member);
                memberTmp = member;
                break;
            }
        }
        if (memberTmp != null) {
            return new ResponseEntity(memberTmp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public static List<TeamMember> createList() {
        List<TeamMember> tmpList = new ArrayList<>();
        TeamMember member1 = new TeamMember(1L, "Jan", "Kowalski", "karate");
        TeamMember member2 = new TeamMember(2L, "Zbyszek", "Kowalski", "judo");
        tmpList.add(member1);
        tmpList.add(member2);
        return tmpList;
    }

}
