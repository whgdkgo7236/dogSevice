package com.icia.dogsevice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FoodPagingDTO {
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fImagefilename;
    private String fImagefilepath;
}
