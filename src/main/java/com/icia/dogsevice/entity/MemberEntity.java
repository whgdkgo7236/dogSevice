package com.icia.dogsevice.entity;

import com.icia.dogsevice.dto.MemberDetailDTO;
import com.icia.dogsevice.dto.MemberSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long mIdnum;

    @Column(unique = true)
    private String mId;

    @Column
    private String mPassword;

    @Column
    private String mEmail;

    @Column
    private String mAddress;

    @Column
    private String mName;

    @Column
    private String mPhonenum;

    @Column
    private String mDogName;

    @Column
    private String mDogage;

    @Column
    private String mDogtraining;

    @Column
    private String mDogtrainingplace;

    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<TradeEntity> tradeEntityList= new ArrayList<>();


    public static MemberEntity toSaveEntity(MemberSaveDTO memberSaveDTO){
        MemberEntity entity = new MemberEntity();
        entity.setMIdnum(memberSaveDTO.getMIdnum());
        entity.setMId(memberSaveDTO.getMId());
        entity.setMPassword(memberSaveDTO.getMPassword());
        entity.setMName(memberSaveDTO.getMName());
        entity.setMAddress(memberSaveDTO.getMAddress());
        entity.setMEmail(memberSaveDTO.getMEmail());
        entity.setMPhonenum(memberSaveDTO.getMPhonenum());

        return entity;
    }
    public static MemberEntity toDetailEntity(MemberDetailDTO memberDetailDTO){
        MemberEntity entity = new MemberEntity();
        entity.setMIdnum(memberDetailDTO.getMIdnum());
        entity.setMId(memberDetailDTO.getMId());
        entity.setMPassword(memberDetailDTO.getMPassword());
        entity.setMName(memberDetailDTO.getMName());
        entity.setMAddress(memberDetailDTO.getMAddress());
        entity.setMEmail(memberDetailDTO.getMEmail());
        entity.setMPhonenum(memberDetailDTO.getMPhonenum());

        return entity;
    }
}
