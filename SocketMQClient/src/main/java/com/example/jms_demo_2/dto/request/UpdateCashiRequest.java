package com.example.jms_demo_2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCashiRequest {
    private String mgniId;
    private String accNo;
    private String ccy;

    private BigDecimal amt;
}
