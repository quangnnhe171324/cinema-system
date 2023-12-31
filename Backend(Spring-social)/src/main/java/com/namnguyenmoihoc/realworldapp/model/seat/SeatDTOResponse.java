package com.namnguyenmoihoc.realworldapp.model.seat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SeatDTOResponse {
    private int seatid;
    private String row;
    private String col;
    private float price;
    private byte active;
    
}