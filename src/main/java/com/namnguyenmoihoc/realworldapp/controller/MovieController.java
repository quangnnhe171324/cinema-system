package com.namnguyenmoihoc.realworldapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namnguyenmoihoc.realworldapp.exception.custom.CustomNotFoundException;
import com.namnguyenmoihoc.realworldapp.model.movie.MovieDTOCreate;
import com.namnguyenmoihoc.realworldapp.model.movie.MovieDTOResponse;
import com.namnguyenmoihoc.realworldapp.model.profileAccount.ProfileDTOResponsive;
import com.namnguyenmoihoc.realworldapp.model.roles.UserRolesDTOResponse;
import com.namnguyenmoihoc.realworldapp.model.user.dto.UserDTOUpdateAccount;
import com.namnguyenmoihoc.realworldapp.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/create")
    public Map<String,MovieDTOResponse> createMovie(
        @RequestBody Map<String , MovieDTOCreate> movieDTOCreateMap){
        return movieService.createMovie(movieDTOCreateMap);
    } 

    @GetMapping("/listMovie")
    public List<MovieDTOResponse> getListMovie(){
        return movieService.getListMovie();
    }

    /*
     * @PutMapping("/updateMovie/{movieId}")
    public Map<String, ProfileDTOResponsive> getUpdateMovie(@PathVariable int movieId,
            @RequestBody UserDTOUpdateAccount userDTOUpdateAccount)
            throws CustomNotFoundException {
        System.out.println(userDTOUpdateAccount);
        userDTOUpdateAccount.setId(userid);
        return userService.getUpdateAccount(userDTOUpdateAccount);
    }
     */
    


    
}