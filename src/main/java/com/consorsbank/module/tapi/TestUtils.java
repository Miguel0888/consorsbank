/*
 * Copyright 2018, Trading-API, Consorsbank.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.consorsbank.module.tapi;

import java.time.LocalDate;
import java.util.Calendar;

import com.consorsbank.module.tapi.grpc.account.TradingAccount;
import com.consorsbank.module.tapi.grpc.common.Date;
import com.consorsbank.module.tapi.grpc.security.SecurityCode;
import com.consorsbank.module.tapi.grpc.security.SecurityCodeType;
import com.consorsbank.module.tapi.grpc.security.SecurityWithStockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange;
import com.consorsbank.module.tapi.grpc.stock.StockExchange.Builder;

public class TestUtils {
  
  
  public static final boolean isFilled(String s) {
    return s!=null && !s.isEmpty();
  }

  // tag::getSecurityCode[]
  public static SecurityCode getSecurityCode(String code, SecurityCodeType codeType) {
    return SecurityCode.newBuilder() // <1>
        .setCode(code) // <2>
        .setCodeType(codeType==null ? SecurityCodeType.NO_CODE_TYPE : codeType) // <3>
        .build(); // <4>
  }
  // end::getSecurityCode[]
  // tag::getStockExchange[]
  public static StockExchange getStockExchange(String stockExchangeId, String issuer) {
    Builder stockBuilder = StockExchange.newBuilder(); // <1>
    if (issuer!=null) {
      stockBuilder.setIssuer(issuer); // <2>
    }
    return stockBuilder.setId(stockExchangeId) // <3>
        .build(); // <4>
  }
  // end::getStockExchange[]

  // tag::getSecurityWithStockExchange[]
  public static SecurityWithStockExchange getSecurityWithStockExchange(
      SecurityCode securityCode, StockExchange stockExchange) {

    return SecurityWithStockExchange.newBuilder() // <1>
        .setSecurityCode(securityCode) // <2>
        .setStockExchange(stockExchange) // <3>
        .build(); // <4>
  }
  // end::getSecurityWithStockExchange[]
  
  //tag::getSecurityWithStockExchange2[]
  public static SecurityWithStockExchange getSecurityWithStockExchange(
      String securityCodeValue, SecurityCodeType securityCodeType, String stockExchangeId, String issuer) {
    SecurityCode securityCode = getSecurityCode(securityCodeValue, securityCodeType);
    StockExchange stockExchange = getStockExchange(stockExchangeId, issuer);
    return getSecurityWithStockExchange(securityCode, stockExchange);
  }
  // end::getSecurityWithStockExchange2[]

  public static TradingAccount getTradingAccount(String accountNo) {
    return TradingAccount.newBuilder().setAccountNumber(accountNo).build();
  }
  
  public static Date getDate(Calendar calendar) {
    return Date.newBuilder()
        .setDay(calendar.get(Calendar.DAY_OF_MONTH))
        .setMonth(calendar.get(Calendar.MONTH)+1)
        .setYear(calendar.get(Calendar.YEAR))
        .build();
  }


  public static Date getDate(LocalDate localDate) {
    return Date.newBuilder()
        .setDay(localDate.getDayOfMonth())
        .setMonth(localDate.getMonthValue())
        .setYear(localDate.getYear())
        .build();
  }
}
