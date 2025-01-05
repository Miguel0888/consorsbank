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
import com.consorsbank.module.tapi.grpc.common.Timestamp;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataReply;
import com.consorsbank.module.tapi.grpc.security.SecurityMarketDataRequest;

// tag::MarketDataDataObserver[]
public class MarketDataDataObserver extends ServerSubscription<SecurityMarketDataRequest, SecurityMarketDataReply> {
  private final SecurityServiceStub securityServiceStub;

  public MarketDataDataObserver(SecurityMarketDataRequest request,
      SecurityServiceStub securityServiceStub) {
    
    this.securityServiceStub = securityServiceStub;
    

    securityServiceStub.streamMarketData(request, this); // <1>
  }
  
  @Override
  public void onCompleted() {
    System.out.println("Call completed!"); // <2>
  }
  
  @Override
  public void onNext(SecurityMarketDataReply response) {
    Error error = response.getError();
    if (error==Error.getDefaultInstance()) { // <3>
      System.out.printf("Async client onNext: %s%n", response);
      double lastPrice = response.getLastPrice();
      Timestamp lastDateTime = response.getLastDateTime();
      // ...
      
    } else {
      System.out.printf("Error: %s%n", error);
    }
  }
}
// end::MarketDataDataObserver[]
