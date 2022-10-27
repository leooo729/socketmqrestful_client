package com.example.jms_demo_2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cashi implements Serializable
{

    private String mgniId;

    private String accNo;

    private String ccy;

    private BigDecimal amt;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "mgni_id")
//    private Mgni mgni;
}
