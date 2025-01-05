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
package com.consorsbank.module.tapi.observers;

import com.consorsbank.module.tapi.grpc.SecurityServiceGrpc.SecurityServiceStub;
import com.consorsbank.module.tapi.grpc.common.Error;
import com.consorsbank.module.tapi.grpc.security.CurrencyRateReply;
import com.consorsbank.module.tapi.grpc.security.CurrencyRateRequest;

// tag::CurrencyRateDataObserver[]
public class CurrencyRateDataObserver extends ServerSubscription<CurrencyRateRequest, CurrencyRateReply> {
  private final SecurityServiceStub securityServiceStub;
  
  public CurrencyRateDataObserver(CurrencyRateRequest request,
      SecurityServiceStub securityServiceStub) {

    this.securityServiceStub = securityServiceStub;


    securityServiceStub.streamCurrencyRate(request, this); // <1>
  }

  @Override
  public void onCompleted() {
    System.out.println("Call completed!"); // <2>
  }

  @Override
  public void onNext(CurrencyRateReply response) {
    Error error = response.getError();
    if (error==Error.getDefaultInstance()) {
      System.out.printf("Async client onNext: %s%n", response);
      double currencyRate = response.getCurrencyRate(); // <3>
      // ...

    } else {
      System.out.printf("Error: %s%n", error);
    }
  }
}
// end::CurrencyRateDataObserver[]
