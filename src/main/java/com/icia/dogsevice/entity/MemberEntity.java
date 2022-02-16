package com.icia.dogsevice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
