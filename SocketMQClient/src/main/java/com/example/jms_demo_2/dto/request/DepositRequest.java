package com.example.jms_demo_2.dto.request;

import com.example.jms_demo_2.dto.response.CashiAccAmt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Validated

public class DepositRequest {
        private String id;

        private String cmNo;

        private String kacType;

        private String bankNo;

        private String ccy;

        private String pvType;

        private String bicaccNo;

        private List<CashiAccAmt> accAmt;
        //        @NotEmpty
//        @Pattern(regexp = "^$|(1234)",message = "請輸入代碼：1~4")
        //private String iTYPE;
        //private String pReason;
        //private BigDecimal amt;

        private String ctName;

        private String ctTel;
        //private String status;
        //private String uTime;
}
