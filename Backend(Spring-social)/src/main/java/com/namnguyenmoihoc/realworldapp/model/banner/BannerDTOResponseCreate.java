package com.namnguyenmoihoc.realworldapp.model.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BannerDTOResponseCreate {
    
    private String picture;
    private byte active;
}
