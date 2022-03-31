package com.icia.dogsevice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FoodSaveDTO {
    private Long fIdnum;
    private String fTitle;
    private String fContents;
    private String fCost;
    private String fPhonenum;
    private MultipartFile fImagefile;
    private String fImagefilename;
    private String fImagefilepath;
}
