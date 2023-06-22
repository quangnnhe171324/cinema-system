package com.namnguyenmoihoc.realworldapp.model.user.mapper;

import com.namnguyenmoihoc.realworldapp.entity.Movie;
import com.namnguyenmoihoc.realworldapp.model.movie.MovieDTOCreate;
import com.namnguyenmoihoc.realworldapp.model.movie.MovieDTOResponse;
import com.namnguyenmoihoc.realworldapp.model.movie.MovieDTOUpdate;

public class MovieMapper {
    public static Movie toMovie(MovieDTOCreate movieDTOcreate) {
       Movie movie = Movie.builder().name(movieDTOcreate.getName()).type(movieDTOcreate.getType())
       .poster(movieDTOcreate.getPoster()).banner(movieDTOcreate.getBanner()).trailer(movieDTOcreate.getTrailer())
       .times(movieDTOcreate.getTimes()).country(movieDTOcreate.getCountry()).show_date(movieDTOcreate.getShow_date())
       .description(movieDTOcreate.getDescription()).build(); 
        return movie;
    }

    public static MovieDTOResponse toMovieDTOReponse(Movie movie) {

        return MovieDTOResponse.builder().name(movie.getName()).type(movie.getType())
       .poster(movie.getPoster()).banner(movie.getBanner()).trailer(movie.getTrailer())
       .times(movie.getTimes()).description(movie.getDescription()).country(movie.getCountry()).show_date(movie.getShow_date()).build();
    }

    public static Movie toMovieUpdate(MovieDTOUpdate movieDTOUpdate) {
       Movie movie = Movie.builder().name(movieDTOUpdate.getName()).type(movieDTOUpdate.getType())
       .poster(movieDTOUpdate.getPoster()).banner(movieDTOUpdate.getBanner()).trailer(movieDTOUpdate.getTrailer())
       .times(movieDTOUpdate.getTimes()).country(movieDTOUpdate.getCountry()).show_date(movieDTOUpdate.getShow_date())
       .description(movieDTOUpdate.getDescription()).build(); 
        return movie;
    }
}
