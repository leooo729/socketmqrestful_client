package com.example.jms_demo_2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchMgniRequest {
    private String id;
    private String kacType;
    private String ccy;
}
