package com.namnguyenmoihoc.realworldapp.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.namnguyenmoihoc.realworldapp.entity.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

        @Query("SELECT DISTINCT s.starttime FROM Showtime s WHERE s.movie.movieid=:movieid AND s.cinema.cinemaid= :cinemaid AND s.startdate=:startdate")
        List<LocalTime> getStartTimeByMovie(@Param("movieid") Integer movieid, @Param("cinemaid") Integer cinemaid,
                        @Param("startdate") LocalDate startdate);

                        @Query("SELECT s FROM Showtime s WHERE s.movie.movieid = :movieid AND s.cinema.cinemaid = :cinemaid AND s.starttime >= :starttime AND s.startdate = :startdate")
                        List<Showtime> getSchedulesByMovie(@Param("movieid") Integer movieid, @Param("cinemaid") Integer cinemaid, @Param("startdate") LocalDate startdate, @Param("starttime") LocalTime starttime);
                        
          @Query("SELECT DISTINCT s.startdate FROM Showtime s WHERE s.movie.movieid=:movieid")
          List<LocalDate> getStartDateMovie(@Param("movieid") Integer movieid);


        


          


}
