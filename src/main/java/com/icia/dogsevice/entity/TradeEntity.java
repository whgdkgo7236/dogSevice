package com.icia.dogsevice.entity;

import com.icia.dogsevice.dto.TradeSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="trade_table")
public class TradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long tIdnum;

    private Long fIdnum;

    private String fTitle;

    private String fContents;

    private String fCost;

    private String fPhonenum;

    private String fImagefilename;

    private String fImagefilepath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    public static TradeEntity toTradeSaveEntity(TradeSaveDTO saveDTO){
        TradeEntity entity = new TradeEntity();
        entity.setFIdnum(saveDTO.getFIdnum());
        entity.setFTitle(saveDTO.getFTitle());
        entity.setFContents(saveDTO.getFContents());
        entity.setFCost(saveDTO.getFCost());
        entity.setFPhonenum(saveDTO.getFPhonenum());
        entity.setFImagefilename(saveDTO.getFImagefilename());
        entity.setFImagefilepath(saveDTO.getFImagefilepath());
        entity.setMemberEntity(saveDTO.getMMemberentity());
        return entity;
    }
}
